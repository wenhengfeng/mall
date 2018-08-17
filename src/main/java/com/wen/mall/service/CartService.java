package com.wen.mall.service;

import com.wen.mall.model.OrderEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author wqp
 * @Description 购物车业务处理类
 * @Date 17:28 2018/7/13
 **/
@Service
public class CartService {

    /**
     * @Method: add
     * @Description: 商品添加购物车
     * @param orderEntity
     * @return java.util.Map<java.lang.String,java.lang.Object>
     * @throws
     */
    public Map<String,Object> add(OrderEntity orderEntity){

        return  null;
    }
    public Map<String,Object> add(int shopId,int goodId,int userId){
         /** 
          * @Method: add 
          * @Description: 商品添加购物车
          * @param shopId, goodId, userId
          * @return java.util.Map<java.lang.String,java.lang.Object>
          * @throws 
          */
        add(new OrderEntity(shopId,goodId,userId));
        return  null;
    }

    /**
     * @Method: remove
     * @Description: 移除商品
     * @param orderEntity
     * @return java.util.Map<java.lang.String,java.lang.Object>
     * @throws
     */
    public Map<String,Object> remove(OrderEntity orderEntity){

        return null;
    }

    /**
     * @Method: remove
     * @Description: 移除商品
     * @param shopId, goodId, userId
     * @return java.util.Map<java.lang.String,java.lang.Object>
     * @throws
     */
    public Map<String,Object> remove(int shopId,int goodId,int userId){

        return  null;
    }
    /**
     * @Method: removes
     * @Description: 移除多个商品
     * @param orderEntities
     * @return java.util.Map<java.lang.String,java.lang.Object>
     * @throws
     */
    public Map<String,Object> removes(List<OrderEntity> orderEntities){

        return  null;
    }
    /**
     * @Method: update
     * @Description: 修改购物车指定商品数量
     * @param orderEntity
     * @return java.util.Map<java.lang.String,java.lang.Object>
     * @throws
     */
    public Map<String,Object> update(OrderEntity orderEntity){

        return null;
    }

    /**
     * @Method: isExist
     * @Description: 判断购物车中是存在指定的商品
     * @param orderEntity
     * @return java.util.Map<java.lang.String,java.lang.Object>
     * @throws
     */
    public Map<String,Object> isExist(OrderEntity orderEntity){

        return null;
    }
    /**
     * @Method: isExist
     * @Description: 判断购物车中是存在指定的商品
     * @param shopId, goodId, userId
     * @return java.util.Map<java.lang.String,java.lang.Object>
     * @throws
     */
    public Map<String,Object> isExist(int shopId,int goodId,int userId){
        isExist(new OrderEntity(shopId,goodId,userId));
        return null;
    }
}