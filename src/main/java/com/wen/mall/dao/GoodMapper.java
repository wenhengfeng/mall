package com.wen.mall.dao;

import com.wen.mall.model.Good;
import com.wen.mall.model.GoodVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface GoodMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Good record);

    int insertSelective(Good record);

    int selectCount();

    List<Good> selectWithPaging(GoodVO goodVO);

    Good selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Good record);

    int updateByPrimaryKey(Good record);


}