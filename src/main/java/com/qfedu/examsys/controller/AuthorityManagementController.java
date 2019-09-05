package com.qfedu.examsys.controller;

import com.qfedu.examsys.service.impl.AuthorityManagementServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @ClassName AuthorityManagementController
 * @Description TODO
 * @Author wangzhendong
 * @Date 2019/9/4
 */
@Controller
public class AuthorityManagementController {

    @Autowired
    private AuthorityManagementServiceImpl authorityManagementService;

    @RequestMapping("/authorityManagement/findAllRole.do")
    @ResponseBody
    public Map<String, Object> findAllRole(Integer page, Integer limit) {
        return authorityManagementService.findAllRole(page, limit);
    }

    @RequestMapping("/authorityManagement/findAllPermission.do")
    @ResponseBody
    public Map<String, Object> findAllPermission() {
        return authorityManagementService.findAllPermission();
    }

    @RequestMapping("/authorityManagement/findAllRolePermission.do")
    @ResponseBody
    public Map<String, Object> findAllRolePermission(Integer rid) {
        return authorityManagementService.findAllRolePermission(rid);
    }

    @RequestMapping("/authorityManagement/addRolePermission.do")
    @ResponseBody
    public Map<String, Object> addRolePermission(@RequestParam("list[]") Integer[] pid, @RequestParam("rid") Integer rid) {
        return authorityManagementService.addRolePermission(pid, rid);
    }

}
