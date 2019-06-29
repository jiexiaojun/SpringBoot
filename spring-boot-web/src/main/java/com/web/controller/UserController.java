package com.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.model.BasUser;
import com.web.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
    @RequestMapping("/getUser")
    // 对比RedisTests类中的手动缓存方式 查找数据库的时候自动使用缓存
    // 其中value的值就是缓存到redis中的key
    @Cacheable(value="user")
    public BasUser getUser() {
    	BasUser user=userRepository.findByUserName("aa");
    	System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");  
        return user;
    }
    
    @RequestMapping("/getUsers")
    @Cacheable(value="users")
    public List<BasUser> getUsers() {
    	List<BasUser> users=userRepository.findAll();
    	System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");  
        return users;
    }
}