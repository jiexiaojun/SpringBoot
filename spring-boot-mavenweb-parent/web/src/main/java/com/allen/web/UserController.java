package com.allen.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.allen.domain.UserEntity;
import com.allen.service.UserService;
import reactor.netty.http.server.HttpServerResponse;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/getUsers")
	// http://localhost:8080/getUsers
	public List<UserEntity> getUsers() {
		List<UserEntity> users = userService.getAll();
		return users;
	}

	@RequestMapping("/getUser")
	// http://localhost:8080/getUser?id=21
	public UserEntity getUser(Long id) {
		UserEntity user = userService.getOne(id);
		return user;
	}

	@RequestMapping("/add")
	// http://localhost:8080/add?userName=allen&passWord=666666&userSex=MAN&nickName=ll
	public UserEntity save(HttpServerResponse response, UserEntity user) {
		return user;
	}

	@RequestMapping(value = "update")
	// http://localhost:8080/update?id=24&userName=liuli&passWord=123456&userSex=WOMAN&nickName=666
	public UserEntity update(UserEntity user) {
		userService.update(user);
		return user;
	}

	@RequestMapping(value = "/delete/{id}")
	// http://localhost:8080/delete/23
	public void delete(@PathVariable("id") Long id) {
		userService.delete(id);
	}


}
