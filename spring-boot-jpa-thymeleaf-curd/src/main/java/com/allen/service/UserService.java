package com.allen.service;

import java.util.List;
import com.allen.entity.UserForJPA;

public interface UserService {

    public List<UserForJPA> getUserList();

    public UserForJPA findUserById(long id);

    public void save(UserForJPA user);

    public void edit(UserForJPA user);

    public void delete(long id);


}
