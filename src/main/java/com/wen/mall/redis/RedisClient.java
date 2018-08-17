package com.wen.mall.redis;

import com.wen.mall.model.Good;
import com.wen.mall.model.GoodPO;
import redis.clients.jedis.Jedis;
import sun.rmi.runtime.Log;

import java.lang.reflect.Field;
import java.util.*;

/**
 * @Author wqp
 * @Description 对象存入redis
 * @Date 11:09 2018/8/14
 */
public class RedisClient<T> {
	/**
	 *  目标对象
	 */
	private Object o;

	private Class c;
	/**
	 * 目标对象名
	 */
	private String oName;
	/**
	 *  key = oName+oId;
	 */
	private String oKey;
	/**
	 *  oId值
	 */
	private Object oId;
	/**
	 *  存放对象o成员变量
	 */
	private List<String> fieldsString;
	private Field[] fields;
	private Map<String,String> oMap;

	/**
	 * jedis连接实例
	 */
	private static Jedis jedis;

	static {
		jedis = RedisConnection.getJedis();
	}

	public RedisClient(Class c){
		this.c = c;
		setoName();
	}




	/**
	 *
	 * @param o 目标对象实例
	 */
	public RedisClient(Object o)   {
		this.o = o;
		this.c = o.getClass();
		setoName();
		setFields();
	}

	/**
	 *  将对象o添加到redis中,如果key已经存在，当b为true时，覆盖原有的值，b为false，则不覆盖。
	 * @param b TODO
	 * @throws IllegalAccessException
	 */
	public void setObject(Boolean b) throws Exception {
		setId();
		setoKey();
		//map添加进redis
		setMap(oMap);
		//将对象id添加进
		setoKeys();
	}
	/**
	 *  1.初始化o成员变量名
	 */
	private void setFields(){
		fieldsString = new ArrayList<>();
		fields = c.getDeclaredFields();
		for (Field f: fields){
			fieldsString.add(f.getName());
		}
	}

	/**
	 *  初始化o对象名
	 */
	private void setoName(){
		oName = c.getSimpleName();
	}

	private void setoName(Class c){
		oName = c.getSimpleName();
	}

	private String getoName(){
		return oName;
	}
	/**
	 *  设置key值
	 */
	private void setoKey(){
		oKey = oName + oId;
	}

	/**
	 *  o对象中必须包含id成员变量，且值不能为空
	 * @throws Exception
	 */
	private void setId() throws Exception{
		if (fieldsString.contains("id")){
			setoMap();
		}else {
			throw new Exception("The object to redis must contain the element id");
		}
	}


	/**
	 * 对象转map
	 * @return
	 * @throws IllegalAccessException
	 */
	private void setoMap() throws Exception{
		oMap = new HashMap<>();
		for (Field f:fields){
			f.setAccessible(true);
			oMap.put(f.getName(),String.valueOf(f.get(o)));
			if ("id".equals(f.getName())){
				if ("".equals(f.get(o)) || null == f.get(o)){
					throw new Exception("The object element id can not be null");
				}else {
					oId = f.get(o);
				}
			}
		}
	}
	/**
	 * 将商品id的集合存入reids
	 */
	private void setoKeys(){
	//	jedis.sadd(oName+"Set",oKey);
		Long i =jedis.zcard(oName+"Set");
		jedis.zadd(oName+"Set",i+1,oKey);
	}

	/**
	 * 将o信息添加到redis
	 * @param map
	 */
	private void setMap(Map<String,String> map)  {
		jedis.hmset(oKey,map);
	}
	/**
	 * 获取对象在redis中的所有key
	 * @param c
	 * @return
	 */
	public static Set<String> getoKeys(Class c){
		return jedis.zrange(c.getSimpleName()+"Set",0,jedis.zcard(c.getSimpleName()+"Set")-1);
	}

	/**
	 * 获取对象在redis中的所有key
	 * @param c
	 * @param start 其实下标
	 * @param end 末位下标
	 * @return
	 */
	public static Set<String> getoKeysRange(Class c,final int start,final int end){
		return jedis.zrange(c.getSimpleName()+"Set",start,end);
	}

	/**
	 *  获取oVal的值
	 * @param k
	 * @return 返回map
	 */
	public static Map<String,String> getoValMap(String k){
		Map<String,String> map =jedis.hgetAll(k);
		return map;
	}

	/**
	 *  获取oVal的值
	 * @param k
	 * @param c
	 * @return 返回object
	 */
	public static Object getoValObj(String k,Class c) throws IllegalAccessException, InstantiationException {
		Map<String,String> map = getoValMap(k);
		//将map转为对象
		Field[] fields = c.getDeclaredFields();
		Object obj = c.newInstance();
		for (Field f:fields){
			if (null != map.get(f.getName()) && !"null".equals(map.get(f.getName()))){
				f.setAccessible(true);
				typeOf(f,obj,map.get(f.getName()));
			}
		}
		return obj;
	}

	/**
	 *  查询object在redis中的所有信息
	 * @param c
	 * @return List<Object>
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public static <E> List<E> getoValObjs(Class c) throws InstantiationException, IllegalAccessException {
		List<E> list = new ArrayList<>();
		Set<String> set = getoKeys(c);
		Iterator<String> it = set.iterator();
		while (it.hasNext()){
			 list.add((E) getoValObj(it.next(),c));
		}
		return list;
	}

	/**
	 *  查询object在redis中的所有信息
	 * @param c
	 * @return List<Map<String,String>>
	 */
	public static List<Map<String,String>> getoValMaps(Class c){
		List<Map<String,String>> list = new ArrayList<>();
		Set<String> set = getoKeys(c);
		Iterator<String> it = set.iterator();
		while (it.hasNext()){
			list.add(getoValMap(it.next()));
		}
		return list;
	}

	private static void typeOf(Field f,Object obj,String val) throws IllegalAccessException {
		if (f.getType() == Integer.class){
			f.set(obj,Integer.valueOf(val));
		}
		if (f.getType() == String.class){
			f.set(obj,val);
		}
		if (f.getType() == Double.class){
			f.set(obj,Double.valueOf(val));
		}
	}

	/**
	 *  校验是否存在c类项的信息
	 * @param c
	 * @return
	 */
	public static  Boolean existC(Class c){
		return jedis.exists(c.getSimpleName()+"Set");
	}

	/**
	 * 校验是否存在对象的信息
	 * @param obj
	 * @return
	 */
	public static Boolean existO(Object obj){
		return null;
	}

}