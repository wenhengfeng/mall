package com.wen.mall.dao;

import com.wen.mall.model.Card;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CardMapper {
    int insert(Card record);

    int insertSelective(Card record);

    List<Card> findByUserId(int userId);

    List<Card> findByShopId(int shopId);
}