package com.neo.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.neo.entity.UserEntity;
import com.neo.mapper.test1.User1Mapper;
import com.neo.mapper.test2.User2Mapper;

@RestController
public class UserController {

	@Autowired
	private User1Mapper user1Mapper;

	@Autowired
	private User2Mapper user2Mapper;

	@RequestMapping("/getUsers")
	// http://localhost:8080/getUsers
	public List<UserEntity> getUsers() {
		List<UserEntity> users = user1Mapper.getAll();
		return users;
	}

	@RequestMapping("/getUser")
	// http://localhost:8080/getUser?id=4
	public UserEntity getUser(Long id) {
		UserEntity user = user2Mapper.getOne(id);
		return user;
	}

	@RequestMapping("/add")
	// http://localhost:8080/add?userName=aa&passWord=a123456&userSex=MAN&nickName=昵称aa
	public void save(UserEntity user) {
		user2Mapper.insert(user);
	}

	@RequestMapping(value = "update")
	// http://localhost:8080/update?id=10&userName=aa&passWord=a123456&userSex=MAN&nickName=昵称aa
	public void update(UserEntity user) {
		user2Mapper.update(user);
	}

	@RequestMapping(value = "/delete/{id}")
	// http://localhost:8080/delete/7
	public void delete(@PathVariable("id") Long id) {
		user1Mapper.delete(id);
	}

}
