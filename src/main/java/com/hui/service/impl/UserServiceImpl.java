package com.hui.service.impl;

import com.hui.dao.UserDao;
import com.hui.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by JianChengCai on 2017/9/11.
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public boolean insertUser(String name, String email, String phone, String industry, String type) {
		return userDao.insertUser(name, email, phone, industry, type);
	}

	@Override
	public List<Map> selectAllUser() {
		return userDao.selectAllUser();
	}

	@Override
	public Integer updateUserById(String id) {
		return userDao.updateUserById(id);
	}

	@Override
	public Integer deleteUserById(String id) {
		return userDao.deleteUserById(id);
	}
}
