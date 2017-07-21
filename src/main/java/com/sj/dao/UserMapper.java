package com.sj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sj.entity.User;

public interface UserMapper {
    int deleteByPrimaryKey(Long userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    List<User> queryAll();
    
    User getLastInsertId();
    
}