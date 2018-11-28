package com.mybatis.neo.mybatisdemo.mapper.two;

import com.mybatis.neo.mybatisdemo.model.User;

import java.util.List;

public interface User2Mapper {
    List<User> getAll();

    User getOne(Long id);

    void insert(User user);

    void update(User user);

    void delete(Long id);

}