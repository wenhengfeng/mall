package com.wen.mall.service;

import com.wen.mall.dao.UserMapper;
import com.wen.mall.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private Map<String ,Object> map;
    @Autowired
    private UserMapper userMapper;

    public Map<String,Object> addUser(User user){
        map = new HashMap<>();
        int i = userMapper.insertSelective(user);
        if (i == 1){
            map.put("msg","success");
        }else {
            map.put("msg","false");
        }
        return  map;
    }
}
