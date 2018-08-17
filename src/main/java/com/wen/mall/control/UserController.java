package com.wen.mall.control;

import com.wen.mall.model.User;
import com.wen.mall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户注册
     * @param name
     * @param loginName
     * @param phone
     * @param password
     * @param sex
     * @return
     */
    @RequestMapping(value = "/registerUser/{name}/{loginName}/{phone}/{password}/{sex}")
    public Map<String,Object> registerUser(@PathVariable String name, @PathVariable String loginName, @PathVariable String phone,
                            @PathVariable String password, @PathVariable String sex){
        return userService.addUser(new User(name,loginName,password,phone,sex));
    }
}
