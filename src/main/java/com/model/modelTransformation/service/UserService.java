package com.model.modelTransformation.service;

import com.model.modelTransformation.entity.User;

import java.util.List;

public interface UserService {
    int addUser(String username,String password,String phone);//增加用户信息接口
    List<User> queryByUsername(String username);//根据用户名查询用户信息
    

}
