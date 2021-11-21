package com.akon.springboot.mybatis.service.impl;

import com.akon.springboot.mybatis.entity.UserInfo;
import com.akon.springboot.mybatis.model.UserInfoMapper;
import com.akon.springboot.mybatis.service.UserService;
import com.akon.springboot.mybatis.utils.CollectionsUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Resource
    private UserInfoMapper mapper;

    @Override
    public UserInfo selectById(Integer userId,String userName) {
        log.info("I'm service -----info");
        log.warn("I'm service -----warn");
        log.error("I'm service -----error");
        return mapper.selectByPrimaryKey(userId,userName);
    }

    @Override
    public List<UserInfo> getUser() {
        return mapper.getUser();
    }

    @Override
    public int addUser(UserInfo user) {
        int i=mapper.insert(user);
        return i;
    }

    @Override
    @Transactional
    public int test() {
        UserInfo user=new UserInfo();
        user.setUserName("JackenChen");
        user.setUserScore(189l);
        user.setUserSex("1");
        user.setUserSlary(19204.5d);
        user.setUserAge(32);
        addUser(user);
        int a=10/0;
        user.setUserName("YamMin");
        addUser(user);
        return 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertBatch(List<UserInfo> list) {
        int count=0;
        if(CollectionsUtil.isEmpty(list)){

            for (int i = 0; i < 10000; i++) {
                List<UserInfo> users=new ArrayList<>();
                for (int j = 0; j < 200; j++) {
                    UserInfo user=new UserInfo();
                    user.setUserAge(new Random().nextInt(100));
                    user.setUserName("akon"+(i*j+j));
                    user.setUserScore(new Random().nextLong());
                    user.setUserSex(new Random().nextInt(2)==0?"M":"F");
                    user.setUserSlary(new Random().nextDouble());
                    users.add(user);
                }
                count+=mapper.insertBatch(users);
            }
        }
        return count;
    }
}
