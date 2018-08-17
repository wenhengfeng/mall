package com.wen.mall.redis;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;

import javax.swing.text.html.HTMLDocument;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Author wqp
 * @Description //TODO ${END}
 * @Date 20:31 2018/8/13
 */
public class RedisConnection {
	private Logger logger = LoggerFactory.getLogger(RedisConnection.class);
	private static Jedis jedis;

	public static Jedis getJedis() {
		return jedis;
	}

	static {
		jedis = new Jedis("127.0.0.1",6379);
	}

	/**
	 * 字符串操作
	 */
	public void setString(){
		jedis.set("name","wen");
		System.out.println(jedis.get("name"));
		//追加
		jedis.append("name","wodemingzi");
		System.out.println(jedis.get("name"));
		//删除键,返回long型，1表示成功，0表示失败
		Long result = jedis.del("name2");

		//设置多个键值对
		jedis.mset("age","20","addr","湖南");
		//获取多个键
		System.out.println(jedis.mget("name","age","addr"));
	}

	/**
	 * 哈希操作
	 */
	public void setHash() {
		Map<String, String> map = new HashMap<>();
		map.put("name", "qian");
		map.put("sex", "man");
		//存储数据
		jedis.hmset("user", map);
		//读取一个数据，返回一个列表类型 [qian,man]
		System.out.println(jedis.hmget("user", "name", "age"));
		//HKEYS key 获取所有哈希表中的字段 返回一个列表[naem,sex]
		System.out.println(jedis.hkeys("user"));
		//HVALS key 获取哈希表中所有值
		System.out.println(jedis.hvals("user"));
		//HLEN key 获取哈希表中所有字段的数量
		System.out.println(jedis.hlen("user"));
		//获取所有键迭代操作
		Iterable<String> iterable = jedis.hkeys("user");
		Iterator<String> iterator = iterable.iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			System.out.println(key + "--" + jedis.hmget("user", key));
		}
	}

	public void setList(){
			//开始前移除所有内容
			jedis.del("Programming language");

			//LPUSH key value1 [value2] 将一个或对个值插入入到列表头部
			jedis.lpush("Programming language","java");
			jedis.lpush("Programming language","python");
			jedis.lpush("Programming language","c++");
			//获取数据返回一个list[python,java]
			//第一个是key，第二个是起始位置，第三个是结束位置
			//其中0表示列表的第一个元素，1表示列表的第二个元素，一次类推
			//也可以使用负数下标，以-1表示列表的最后一个元素，-2表示列表的倒数第二个元素
			System.out.println(jedis.lrange("Programming language",0,-1));
			//LPUSHX key value 将一个值插入到已存在的列表的头部
			jedis.lpushx("Programming language","php");
			System.out.println(jedis.lrange("Programming language",0,-1));
			//RPUSH key value1 [value2] 在列表中添加一个或多个值
			jedis.rpush("Programming language","c");
			System.out.println(jedis.lrange("Programming language",0,-1));
	}

	/**
	 * 插入set
	 */
	public void setSet(){
		//将集合添加一个或多个成员
		jedis.sadd("website","阿里","网易");
		jedis.sadd("website","腾讯");
		//SCARD key 获取集合的成员数
		System.out.println(jedis.scard("website"));
		//SMEMBERS key 返回集合中所有成员 返回类型列表[阿里，腾讯，网易] 注意顺序不唯一
		System.out.println(jedis.smembers("website"));
		//SSCAN key cursor [MATCH pattern] [COUNT count] 迭代集合中的元素
		System.out.println(jedis.sscan("website","0"));

	}

	/**
	 * 插入有序set
	 */
	public void sortSet(){
		//redis有序集合和集合一样也是string类型元素的集合，且不允许重复的成员
		//不同的是每个呀U尿素都会关联一个double类型的分数，redis正是通过集合中的成员进行从小到大的排序
		//有序集合的成员是唯一的，但看分数（score）却可以重复
		jedis.zadd("city",0,"北京");
		jedis.zadd("city",1,"上海");
		jedis.zadd("city",2,"南京");

		//ZCARD key 获取有序集合的成员数
		System.out.println(jedis.zcard("city"));
		//ZREVRANK key member 返回有序集合中指定的成员的排名，有序集合按分数值递减（从大到小）排序
		//java中的方法是zrevrangeByScore
	System.out.println(jedis.zrevrangeByScore("city",5,0));
	}






}