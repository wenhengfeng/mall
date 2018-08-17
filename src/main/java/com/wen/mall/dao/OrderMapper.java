package com.wen.mall.dao;

import com.wen.mall.model.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {
    int insert(Order record);

    int insertSelective(Order record);
}