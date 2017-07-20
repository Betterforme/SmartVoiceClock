package com.sj.service;

import java.util.List;

import com.sj.dto.AppointExecution;
import com.sj.entity.Book;
import com.sj.entity.User;

/**
 * 业务接口：站在"使用者"角度设计接口 三个方面：方法定义粒度，参数，返回类型（return 类型/异常）
 */
public interface UserService {

	/**
	 * 查询某个用户的信息
	 * 
	 * @param userid
	 * @return
	 */
	User getUserById(long userid);

	/**
	 * 查询所有用户
	 * 
	 * @return
	 */
	List<User> getList();

	/*
	 * 插入用户
	 * 
	 */
	
	int userLogin(User user);
	
	/*
	 * 注册用户
	 */
	User userRegist(User user);
}
