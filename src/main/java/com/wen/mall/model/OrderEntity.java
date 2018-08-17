package com.wen.mall.model;
/**
 * @Author wqp
 * @Description 购物时商品信息的唯一验证
 * @Date 17:36 2018/7/13
 **/
public class OrderEntity {
    private int shopId;
    private int goodId;
    private int userId;

    public OrderEntity() {
    }

    public OrderEntity(int shopId, int goodId, int userId) {
        this.shopId = shopId;
        this.goodId = goodId;
        this.userId = userId;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public int getGoodId() {
        return goodId;
    }

    public void setGoodId(int goodId) {
        this.goodId = goodId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "OrderEntity{" +
                "shopId=" + shopId +
                ", goodId=" + goodId +
                ", userId=" + userId +
                '}';
    }
}