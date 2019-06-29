/**
 * @项目名称：spring-boot-app
 * @文件名称：UserController.java
 * @所属包名：com.allen.controller
 * @创建时间：2019年6月28日上午10:35:02
 * @Copyright (c) 2019 SLPCB All Rights Reserved.
 */
package com.allen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.allen.domain.User;
import com.allen.repository.UserRepository;

/**
 * @类名称：UserController
 * @类描述：
 * @创建人：allen
 * @创建时间：2019年6月28日 上午10:35:02
 */
@RestController
public class UserController {

	// 保存方式 使用spring web mvc

	private UserRepository userrepository;


	@Autowired
	public UserController(UserRepository userrepository) {
		this.userrepository = userrepository;
	}

	@GetMapping("/user/save")
	public User user(@RequestParam String name) {
		User user = new User();
		user.setName(name);
		userrepository.save(user);
		return user;

	}

}

