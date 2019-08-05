package com.model.modelTransformation.mapper;

import com.model.modelTransformation.entity.TransformationModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ModelMapper {
    //注意接口名称与数据库的 id 对应
    //int addUser(User user);
    TransformationModel queryByModelname(String modelname);
    List<TransformationModel> showModelList();
    List<TransformationModel> findPages(Integer startPos,Integer pageSize) throws Exception;

}
