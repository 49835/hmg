package com.oracle.gdms.service;

import com.oracle.gdms.entity.UserModel;

/**
 * 此类是用户相关业务功能接口
 * @author VX：23482378
 * 2020-7-6
 */
public interface UserService {
	
	/**
	 * 新用户注册业务
	 * @param user
	 * @return
	 */
	int add(UserModel user);

	UserModel login(UserModel user);
}
