package com.model.modelTransformation.service.impl;

import com.model.modelTransformation.entity.User;
import com.model.modelTransformation.mapper.UserMapper;
import com.model.modelTransformation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    public int addUser(String username,String password,String phone){
        User user = new User(username,password,phone);
        int count = userMapper.addUser(user);
        return count;
    }
    public List<User> queryByUsername(String username){
        List <User> userList = userMapper.queryByUsername(username);
        return userList;
    }
}
