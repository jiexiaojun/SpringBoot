package com.shiro.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.shiro.model.UserInfo;
import com.shiro.service.UserInfoService;

@Controller
@RequestMapping("/userInfo")
public class UserInfoController {

	@Autowired
	private UserInfoService userInfoService;


	/**
	 * 用户查询.
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/userList")
	@RequiresPermissions("userInfo:view")
	// 权限管理;
	public UserInfo userInfo() {
		UserInfo userInfo = userInfoService.findByUsername("admin");
		System.out.println("ddddddddddddddddddddddddddddddddddddd");
		return userInfo;
	}

	/**
	 * 用户添加;
	 * @return
	 */
	@RequestMapping("/userAdd")
	@RequiresPermissions("userInfo:add")
	// 权限管理;
	public String userInfoAdd() {
		return "/shiro/userInfoAdd";
	}

	/**
	 * 用户删除;
	 * @return
	 */
	@RequestMapping("/userDel")
	@RequiresPermissions("userInfo:del")
	// 权限管理;
	public String userDel() {
		return "/shiro/userInfoDel";
	}
}
