package com.qfedu.examsys.dao;

import com.qfedu.examsys.entity.Permission;
import com.qfedu.examsys.entity.Role;
import com.qfedu.examsys.entity.RolePermission;

import java.util.List;

/**
 * @ClassName AuthorityManagementDao
 * @Description TODO
 * @Author wangzhendong
 * @Date 2019/9/4
 */
public interface AuthorityManagementDao {

    List<Role> findAllRole();

    List<Permission> findAllPermission();

    List<RolePermission> findAllRolePermission(Integer rid);

    void deleteByIdRolePermission(Integer rid);

    void addRolePermission(List<RolePermission> rolePermissions);
}
