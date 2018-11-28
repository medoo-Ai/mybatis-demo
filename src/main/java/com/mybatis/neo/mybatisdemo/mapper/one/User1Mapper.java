package com.mybatis.neo.mybatisdemo.mapper.one;


import com.mybatis.neo.mybatisdemo.base.UserParam;
import com.mybatis.neo.mybatisdemo.model.User;

import java.util.List;

public interface User1Mapper {

    List<User> getAll();

    User getOne(Long id);

    void insert(User user);

    void update(User user);

    void delete(Long id);

    //  分页查询
    List<User> getList(UserParam userParam);
    //获取分页数目
    int getCount(UserParam userParam);

}