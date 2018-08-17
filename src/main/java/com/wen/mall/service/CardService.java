package com.wen.mall.service;

import com.wen.mall.dao.CardMapper;
import com.wen.mall.model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CardService {
    private Map<String,Object> map;

    @Autowired
    private CardMapper cardMapper;

    public Map<String,Object> add(Card card){
        map = new HashMap<String,Object>();
        int i = cardMapper.insertSelective(card);
        if (i == 1){
            map.put("msg","success");
        }else {
            map.put("msg","false");
        }
        return  map;
    }
    public Map<String,Object> add(int userId,int goodId,int number){
        return  add(new Card(userId,goodId,number));
    }

    /**
     * 用户查询购物车商品信息
     * @param userId
     * @return
     */
    public List<Card> find(int userId){
        return cardMapper.findByUserId(userId);
    }
}
