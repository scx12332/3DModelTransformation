package com.model.modelTransformation.service;

import com.model.modelTransformation.entity.TransformationModel;

import java.util.List;


public interface ModelService {
    //int addUser(String username, String password, String phone);//增加用户信息接口
    TransformationModel queryByModelname(String modelname);//根据用户名查询用户信息

    List<TransformationModel> showModelList();
}
