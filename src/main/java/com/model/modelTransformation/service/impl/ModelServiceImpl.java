package com.model.modelTransformation.service.impl;

import com.model.modelTransformation.entity.TransformationModel;
import com.model.modelTransformation.mapper.ModelMapper;
import com.model.modelTransformation.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelServiceImpl implements ModelService {
    @Autowired
    ModelMapper modelMapper;

    public TransformationModel queryByModelname(String modelname){
        TransformationModel modelInfo = modelMapper.queryByModelname(modelname);
        return modelInfo;
    }

    public List<TransformationModel> showModelList()
    {
        List<TransformationModel> modelList=modelMapper.showModelList();
        return modelList;
    }
}
