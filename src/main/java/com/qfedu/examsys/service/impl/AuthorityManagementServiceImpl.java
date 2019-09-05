package com.qfedu.examsys.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qfedu.examsys.dao.AuthorityManagementDao;
import com.qfedu.examsys.entity.Permission;
import com.qfedu.examsys.entity.Role;
import com.qfedu.examsys.entity.RolePermission;
import com.qfedu.examsys.service.AuthorityManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName AuthorityManagementServiceImpl
 * @Description TODO
 * @Author wangzhendong
 * @Date 2019/9/4
 */
@Service
public class AuthorityManagementServiceImpl implements AuthorityManagementService {

    @Autowired(required = false)
    private AuthorityManagementDao authorityManagementDao;

    @Override
    public Map<String, Object> findAllRole(Integer page, Integer limit) {
        //在执行的SQL语句后面拼上分页
        PageHelper.startPage(page, limit);

        List<Role> role = authorityManagementDao.findAllRole();

        //获取总数据条数
        long total = ((Page) role).getTotal();

        HashMap<String, Object> map = new HashMap<>(16);
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", total);
        map.put("data", role);
        return map;
    }

    @Override
    public Map<String, Object> findAllPermission() {
        List<Permission> permission = authorityManagementDao.findAllPermission();
        HashMap<String, Object> map = new HashMap<>(16);
        map.put("code", 0);
        map.put("info", permission);
        return map;
    }

    @Override
    public Map<String, Object> findAllRolePermission(Integer rid) {
        List<RolePermission> rolePermission = authorityManagementDao.findAllRolePermission(rid);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < rolePermission.size(); i++) {
            Integer pid = rolePermission.get(i).getPid();
            list.add(pid);
        }
        HashMap<String, Object> map = new HashMap<>(16);
        map.put("code", 0);
        map.put("info", list);
        return map;
    }

    @Override
    public Map<String, Object> addRolePermission(Integer[] pid, Integer rid) {
        List<RolePermission> rolePermissions = new ArrayList<>();
        RolePermission rolePermission = null;
        for (int i = 0; i < pid.length; i++) {
            rolePermission = new RolePermission();
            rolePermission.setRid(rid);
            rolePermission.setPid(pid[i]);
            rolePermissions.add(rolePermission);
        }
        authorityManagementDao.deleteByIdRolePermission(rid);
        authorityManagementDao.addRolePermission(rolePermissions);
        HashMap<String, Object> map = new HashMap<>(16);
        map.put("code", 0);
        map.put("info", "添加成功");
        return map;
    }
}
