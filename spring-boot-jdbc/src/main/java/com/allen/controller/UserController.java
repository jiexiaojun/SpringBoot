/**
 * @项目名称：spring-boot-jdbc
 * @文件名称：UserController.java
 * @所属包名：com.allen.controller
 * @创建时间：2019年6月26日上午10:35:25
 * @Copyright (c) 2019 SLPCB All Rights Reserved.
 */
package com.allen.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.allen.domain.User;
import com.allen.repository.UserRepository;

/**
 * @类名称：UserController
 * @类描述:
 * @创建人：allen
 * @创建时间：2019年6月26日 上午10:35:25
 */
@RestController
public class UserController {

	private final UserRepository userRepository;

	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@PostMapping("/web/mvc/user/save")
	public boolean save(@RequestBody User user) {
		System.out.println("UserController Thread:" + Thread.currentThread().getName());
		return userRepository.save(user);
	}
}

