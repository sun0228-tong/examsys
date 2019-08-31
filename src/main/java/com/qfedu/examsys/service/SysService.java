package com.qfedu.examsys.service;

import com.qfedu.examsys.entity.Authority;
import com.qfedu.examsys.entity.User;
import com.qfedu.examsys.vo.VAuthority;
import com.qfedu.examsys.vo.VUser;

import java.util.List;

public interface SysService {

    public List<VAuthority> findAuthorityById(Integer uid);

    public List<VUser> findAllUsers(Integer page, Integer limit);

    public void deleteUserById(Integer uid);

    public VUser findUserById(Integer uid);

    public void updateUserById(User user);

    public void addUser(VUser vUser);

    public void addRole(Integer uid, Integer rid);

    public void updateRoleById(Integer uid, Integer rid);
}
