package com.akon.springboot.mybatis.model;

import com.akon.springboot.mybatis.entity.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserInfoMapper {
    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    int insertBatch(List<UserInfo> list);

    UserInfo selectByPrimaryKey(@Param("userId") Integer id,@Param("userName") String name);

    List<UserInfo> getUser();
}