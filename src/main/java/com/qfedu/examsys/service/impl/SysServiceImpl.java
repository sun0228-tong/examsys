package com.qfedu.examsys.service.impl;

import com.github.pagehelper.PageHelper;
import com.qfedu.examsys.dao.SysDao;
import com.qfedu.examsys.entity.Authority;
import com.qfedu.examsys.entity.User;
import com.qfedu.examsys.service.SysService;
import com.qfedu.examsys.vo.VAuthority;
import com.qfedu.examsys.vo.VUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysServiceImpl implements SysService {

    @Autowired(required = false)
    private SysDao sysDao;

    @Override
    public List<VAuthority> findAuthorityById(Integer uid) {
        List<VAuthority> vAuthority = sysDao.query(uid);
        return vAuthority;
    }

    @Override
    public List<VUser> findAllUsers(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        List<VUser> list = sysDao.queryUser();

        return list;
    }

    @Override
    public void deleteUserById(Integer uid) {
        sysDao.deleteById(uid);
    }

    @Override
    public VUser findUserById(Integer uid) {
        return sysDao.findById(uid);
    }

    @Override
    public void updateUserById(User user) {
        sysDao.updateById(user);
    }

    @Override
    public void addUser(VUser vUser) {
        sysDao.addUser(vUser);
    }

    @Override
    public void addRole(Integer uid, Integer rid) {
        sysDao.addRole(uid,rid);
    }

    @Override
    public void updateRoleById(Integer uid, Integer rid) {
        sysDao.updateRole(uid,rid);
    }
}
