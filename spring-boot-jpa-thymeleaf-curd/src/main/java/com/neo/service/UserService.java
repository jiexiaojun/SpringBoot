package com.neo.service;

import com.neo.entity.UserForJPA;

import java.util.List;

public interface UserService {

    public List<UserForJPA> getUserList();

    public UserForJPA findUserById(long id);

    public void save(UserForJPA user);

    public void edit(UserForJPA user);

    public void delete(long id);


}
