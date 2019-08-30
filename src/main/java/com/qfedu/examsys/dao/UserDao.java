package com.qfedu.examsys.dao;

import com.qfedu.examsys.entity.User;

import java.util.List;

public interface UserDao {

    public User findByName(String userName);

    public List<String> findPermsByName(String userName);
}
