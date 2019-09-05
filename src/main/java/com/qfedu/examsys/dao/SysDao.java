package com.qfedu.examsys.dao;

import com.qfedu.examsys.entity.User;
import com.qfedu.examsys.vo.VAuthority;
import com.qfedu.examsys.vo.VUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysDao {

    public List<VAuthority> query(Integer uid);

    public List<VUser> queryUser();

    public void deleteById(Integer uid);

    public VUser findById(Integer uid);

    public void updateById(User user);

    public void addUser(VUser vUser);

    public void addRole(@Param("uid") Integer uid, @Param("rid") Integer rid);

    public void updateRole(@Param("uid") Integer uid, @Param("rid") Integer rid);
}
