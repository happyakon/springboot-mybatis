package com.akon.springboot.mybatis.service;

import com.akon.springboot.mybatis.entity.UserInfo;

import java.util.List;

public interface UserService {
     List<UserInfo> getUser();

     int addUser(UserInfo user);

     int test();

     UserInfo selectById(Integer userId,String userName);

     int insertBatch(List<UserInfo> list);
}
