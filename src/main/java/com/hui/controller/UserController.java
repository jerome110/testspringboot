package com.hui.controller;

import com.hui.dto.JsonResult;
import com.hui.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sun.awt.SunHints;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by JianChengCai on 2017/9/11.
 */
@Api(value = "/user", description = "Operations about user")
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * Hello World!
	 *
	 * @return
	 */
	@ApiOperation(value = "Hello World!", response = JsonResult.class)
	@RequestMapping(value = "/", method = RequestMethod.GET)
	JsonResult home() {
		JsonResult jsonResult = new JsonResult();
		jsonResult.setData("Hello World!");
		return jsonResult;
	}

	/**
	 * 查询
	 *
	 * @return
	 */
	@ApiOperation(value = "查询所有用户", response = JsonResult.class)
	@RequestMapping(value = "/selectAllUser", method = RequestMethod.POST)
	JsonResult selectAllUser() {
		JsonResult jsonResult = new JsonResult();
		jsonResult.setData(userService.selectAllUser());
		return jsonResult;
	}

	/**
	 * 修改用户
	 *
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "修改用户", response = JsonResult.class)
	@RequestMapping(value = "/updateUserById", method = RequestMethod.POST)
	JsonResult updateUserById(String id) {
		System.out.println(id);
		JsonResult jsonResult = new JsonResult();
		jsonResult.setData(userService.updateUserById(id));
		return jsonResult;
	}

	/**
	 * 增加
	 *
	 * @param name
	 * @param email
	 * @param phone
	 * @param industry
	 * @param type
	 * @return
	 */
	@ApiOperation(value = "增加用户", response = JsonResult.class)
	@RequestMapping(value = "/insertUser", method = RequestMethod.POST)
	JsonResult insertUser(String name, String email, String phone, String industry, String type) {
		JsonResult jsonResult = new JsonResult();
		jsonResult.setData(userService.insertUser(name, email, phone, industry, type));
		return jsonResult;
	}

	/**
	 * 删除用户
	 *
	 * @param id
	 * @return
	 */
	@ApiOperation(value = "删除用户", response = JsonResult.class)
	@RequestMapping(value = "/deleteUserById", method = RequestMethod.GET)
	JsonResult deleteUserById(String id) {
		System.out.println(id);
		JsonResult jsonResult = new JsonResult();
		jsonResult.setData(userService.deleteUserById(id));
		return jsonResult;
	}

}
