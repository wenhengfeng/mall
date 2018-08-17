package com.wen.mall.service;

import com.wen.mall.dao.GoodMapper;
import com.wen.mall.model.Good;
import com.wen.mall.model.GoodPO;
import com.wen.mall.model.GoodVO;
import com.wen.mall.redis.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import util.PagingJson;
import util.PagingUtill;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class GoodService {
    private Map<String,Object> map;
    @Autowired
    private GoodMapper goodMapper;



    public Map<String,Object> addGood(Good good){
        map = new HashMap<>();
        int i = goodMapper.insertSelective(good);
        if (i == 1){
            map.put("msg","success");
        }else {
            map.put("msg","false");
        }
        return  map;
    }

    /**
     * @Method: findGoods
     * @Description: 查询商品信息（分页）
     * @param goodVO
     * @return util.PagingJson<com.wen.mall.model.Good>
     * @throws
     */
    public PagingJson<Good> findGoods(GoodVO goodVO){
        PagingJson<Good> pagingJson = new PagingJson<>();
        List<Good> goods = goodMapper.selectWithPaging(goodVO);
        int count = goodMapper.selectCount();
        pagingJson.settList(goods);
        pagingJson.setCount(count);
        return pagingJson;
    }

    public Good findGood(int id){
        return  goodMapper.selectByPrimaryKey(id);
    }



	/**
	 *  从redis获取所有商品信息
	 * @return
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public List<GoodPO> findGoodsFromRedis() throws IllegalAccessException, InstantiationException {
		List<GoodPO> goodPOs =  RedisClient.getoValObjs(GoodPO.class);
		return goodPOs;
	}

}
