package com.wen.mall.model;

import java.math.BigDecimal;

/**
 * @Author wqp
 * @Description 商品信息
 * @Date 16:00 2018/8/15
 */
public class GoodPO {
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
	private Double goodPrice;

	/**
	 * 商品类型
	 */
	private String goodStyle;

	/**
	 * 库存
	 */
	private Integer goodRemaing;

	/**
	 * 商店id
	 */
	private Integer shopId;

	/**
	 * 暂时未用
	 */
	private Integer count;


	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
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

	public Integer getGoodRemaing() {
		return goodRemaing;
	}

	public void setGoodRemaing(Integer goodRemaing) {
		this.goodRemaing = goodRemaing;
	}

	public Integer getShopId() {
		return shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	@Override
	public String toString() {
		return "GoodPO{" +
				"id=" + id +
				", goodName='" + goodName + '\'' +
				", goodPrice=" + goodPrice +
				", goodStyle='" + goodStyle + '\'' +
				", goodRemaing=" + goodRemaing +
				", shopId=" + shopId +
				", count=" + count +
				'}';
	}
}