package com.wen.mall.model;

import java.util.Date;

public class Order {
    private String id;

    private Integer userId;

    private Integer shopId;

    private Integer goodId;

    private Date createTime;

    private String status;

    private String address;

    private Double price;

    private int number;

    public Order() {
    }

    public Order(Integer userId, Integer shopId, Integer goodId) {
        this.userId = userId;
        this.shopId = shopId;
        this.goodId = goodId;
    }

    public Order(Integer userId, Integer shopId, Integer goodId, int number) {
        this.userId = userId;
        this.shopId = shopId;
        this.goodId = goodId;
        this.number = number;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", userId=" + userId +
                ", shopId=" + shopId +
                ", goodId=" + goodId +
                ", createTime=" + createTime +
                ", status='" + status + '\'' +
                ", address='" + address + '\'' +
                ", price=" + price +
                ", number=" + number +
                '}';
    }
}