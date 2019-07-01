/**
 * @项目名称：service
 * @文件名称：UserService.java
 * @所属包名：com.allen.service
 * @创建时间：2019年6月29日下午4:29:28
 * @Copyright (c) 2019 SLPCB All Rights Reserved.
 */
package com.allen.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.allen.dao.UserMapper;
import com.allen.domain.UserEntity;

/**
 * @类名称：UserService
 * @类描述：
 * @创建人：allen
 * @创建时间：2019年6月29日 下午4:29:28
 */

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;

	public List<UserEntity> getAll() {
		List<UserEntity> users = userMapper.getAll();
		return users;
	}

	public UserEntity getOne(Long id) {
		UserEntity user = userMapper.getOne(id);
		return user;
	}

	public UserEntity save(UserEntity user) {
		userMapper.insert(user);
		return user;
	}

	public UserEntity update(UserEntity user) {
		userMapper.update(user);
		return user;
	}


	public String delete(Long id) {
		userMapper.delete(id);
		return "删除成功";
	}
}

