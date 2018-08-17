package com.wen.mall.model;

import java.math.BigDecimal;

public class Card {
    private Integer id;
    private Integer cUserId;
    private Integer goodId;
    private Integer shopId;
    private Integer number;
    private String shopName;
    private String goodName;
    private String name;
    private BigDecimal goodPrice;
    private String goodStyle;
    private int goodRemaing;

    public Card() {
    }

    public Card(Integer cUserId, Integer goodId, Integer number) {
        this.cUserId = cUserId;
        this.goodId = goodId;
        this.number = number;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getcUserId() {
        return cUserId;
    }

    public void setcUserId(Integer cUserId) {
        this.cUserId = cUserId;
    }

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public BigDecimal getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(BigDecimal goodPrice) {
        this.goodPrice = goodPrice;
    }

    public String getGoodStyle() {
        return goodStyle;
    }

    public void setGoodStyle(String goodStyle) {
        this.goodStyle = goodStyle;
    }

    public int getGoodRemaing() {
        return goodRemaing;
    }

    public void setGoodRemaing(int goodRemaing) {
        this.goodRemaing = goodRemaing;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}