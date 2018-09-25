package com.shiro.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shiro.model.UserInfo;
import com.shiro.repository.UserInfoDao;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    private UserInfoDao userInfoDao;
    @Override
    public UserInfo findByUsername(String username) {
        System.out.println("UserInfoServiceImpl.findByUsername()");
        return userInfoDao.findByUsername(username);
    }
}