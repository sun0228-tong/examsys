package com.qfedu.examsys.service;

import com.qfedu.examsys.entity.RolePermission;

import java.util.List;
import java.util.Map;

/**
 * @ClassName AuthorityManagementService
 * @Description TODO
 * @Author wangzhendong
 * @Date 2019/9/4
 */
public interface AuthorityManagementService {

    Map<String, Object> findAllRole(Integer page, Integer limit);

    Map<String, Object> findAllPermission();

    Map<String, Object> findAllRolePermission(Integer rid);

    Map<String, Object> addRolePermission(Integer[] pid, Integer rid);

}
