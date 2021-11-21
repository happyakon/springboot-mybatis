package com.akon.springboot.mybatis.rest;

import com.akon.springboot.mybatis.entity.UserInfo;
import com.akon.springboot.mybatis.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class UserInfoRest {

    @Autowired
    private UserService userService;

    @GetMapping(value = "getUser")
    public Map<String,Object> getUser(){
        List<UserInfo> list= userService.getUser();
        Map<String,Object> map=new HashMap<>();
        map.put("list",list);
        return map;
    }

    @GetMapping(value = "addUser")
    public String addUser(){
        UserInfo user=new UserInfo();
        user.setUserName("jetLi");
        user.setUserScore(185L);
        user.setUserSex("1");
        user.setUserSlary(19204.5d);
        userService.addUser(user);
        return "success";
    }
    @GetMapping(value = "test")
    public String test(){
        userService.test();
        return "success";
    }
    @GetMapping(value = "findUser")
    public UserInfo findUser(Integer userId,String userName){
        for (int i = 0; i <2000 ; i++) {
            log.debug("userId:{},userName:{}",userId,userName);
            log.info("userId:{},userName:{}",userId,userName);
            log.warn("userId:{},userName:{}",userId,userName);
            log.error("userId:{},userName:{}",userId,userName);
        }
        return userService.selectById(userId,userName);
    }

}
