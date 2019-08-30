package com.qfedu.examsys.service.impl;

import com.qfedu.examsys.dao.UserDao;
import com.qfedu.examsys.entity.User;
import com.qfedu.examsys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired(required = false)
    private UserDao userDao;

    @Override
    public User login(String userName) {
        User user = userDao.findByName(userName);
        return user;
    }


}
