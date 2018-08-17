package com.wen.mall.model;

import java.math.BigDecimal;

public class Good {
    /**
     * 商品id
     */
    private Integer id;

    /**
     * 商品名称
     */
    private String goodName;

    /**
     * 商品价格
     */
    private double goodPrice;

    /**
     * 商品类型
     */
    private String goodStyle;

    /**
     * 库存
     */
    private int goodRemaing;

    /**
     * 商店id
     */
    private int shopId;

	/**
	 * 暂时未用
	 */
	private int count;
    public Good() {
    }

    public Good(String goodName, double goodPrice, String goodStyle, int goodRemaing) {
        this.goodName = goodName;
        this.goodPrice = goodPrice;
        this.goodStyle = goodStyle;
        this.goodRemaing = goodRemaing;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName == null ? null : goodName.trim();
    }

    public double getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(double goodPrice) {
        this.goodPrice = goodPrice;
    }

    public String getGoodStyle() {
        return goodStyle;
    }

    public void setGoodStyle(String goodStyle) {
        this.goodStyle = goodStyle == null ? null : goodStyle.trim();
    }

    public int getGoodRemaing() {
        return goodRemaing;
    }

    public void setGoodRemaing(int goodRemaing) {
        this.goodRemaing = goodRemaing;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }
}