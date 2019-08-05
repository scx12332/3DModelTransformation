package com.model.modelTransformation.mapper;

import com.model.modelTransformation.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface UserMapper {
    //注意接口名称与数据库的 id 对应
    int addUser(User user);
    List<User> queryByUsername(String username);
    List<User> findPages(Integer startPos,Integer pageSize) throws Exception;

}
