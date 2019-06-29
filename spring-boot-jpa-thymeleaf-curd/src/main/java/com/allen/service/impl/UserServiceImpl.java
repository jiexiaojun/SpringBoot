package com.allen.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.allen.entity.UserForJPA;
import com.allen.repository.UserRepository;
import com.allen.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<UserForJPA> getUserList() {
		return userRepository.findAll();
	}

	@Override
	public UserForJPA findUserById(long id) {
		return userRepository.findById(id);
	}

	@Override
	public void save(UserForJPA user) {
		userRepository.save(user);
	}

	@Override
	public void edit(UserForJPA user) {
		userRepository.save(user);
	}

	@Override
	public void delete(long id) {
		userRepository.delete(id);
	}
}
