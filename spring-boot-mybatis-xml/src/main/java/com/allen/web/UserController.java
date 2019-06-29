package com.allen.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.allen.entity.UserEntity;
import com.allen.mapper.UserMapper;

@RestController
public class UserController {

	@Autowired
	private UserMapper userMapper;

	@RequestMapping("/getUsers")
	// http://localhost:8080/getUsers
	public List<UserEntity> getUsers() {
		List<UserEntity> users = userMapper.getAll();
		return users;
	}

	@RequestMapping("/getUser")
	// http://localhost:8080/getUser?id=20
	public UserEntity getUser(Long id) {
		UserEntity user = userMapper.getOne(id);
		return user;
	}

	@RequestMapping("/add")
	// http://localhost:8080/add?userName=aa&passWord=a123456&userSex=MAN&nickName=昵称aa
	public void save(UserEntity user) {
		userMapper.insert(user);
	}

	@RequestMapping(value = "update")
	// http://localhost:8080/update?id=10&userName=aa&passWord=a123456&userSex=MAN&nickName=昵称aa
	public void update(UserEntity user) {
		userMapper.update(user);
	}

	@RequestMapping(value = "/delete/{id}")
	// http://localhost:8080/delete/9
	public void delete(@PathVariable("id") Long id) {
		userMapper.delete(id);
	}


}
