package com.qfedu.examsys.controller;

import com.github.pagehelper.Page;
import com.qfedu.examsys.common.JsonResult;
import com.qfedu.examsys.entity.Authority;
import com.qfedu.examsys.entity.User;
import com.qfedu.examsys.service.SysService;
import com.qfedu.examsys.service.UserService;
import com.qfedu.examsys.vo.VAuthority;
import com.qfedu.examsys.vo.VUser;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
@RequestMapping("/sys")
public class SysController {

    @Autowired
    private SysService sysService;

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("/findAuthorityById.do")
    public List<VAuthority> findAuthorityById(Integer uid) {
        List<VAuthority> list = sysService.findAuthorityById(uid);

        return list;
    }

    @RequestMapping("/userList.do")
    @ResponseBody
    public Map<String, Object> listUsers(Integer page, Integer limit) {
        List<VUser> list = sysService.findAllUsers(page, limit);

        long total = ((Page)list).getTotal();
        Map<String, Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",total);
        map.put("data",list);

        return map;
    }

    @ResponseBody
    @RequestMapping("/deleteUser.do")
    public JsonResult deleteUser(Integer uid) {
        sysService.deleteUserById(uid);
        return new JsonResult(1,null);
    }

    @ResponseBody
    @RequestMapping("/query.do")
    public JsonResult findById(Integer uid) {
        VUser vUser = sysService.findUserById(uid);
        return new JsonResult(1,vUser);
    }

    @ResponseBody
    @RequestMapping("/update.do")
    public JsonResult updateById(User user) {

        // 用户密码采用MD5算法和salt值加密
        String s = md5(user.getPassword());
        user.setPassword(s);

        sysService.updateUserById(user);
        return new JsonResult(1,null);
    }

    @ResponseBody
    @RequestMapping("/addUser.do")
    public JsonResult addUser(VUser vUser) {

        String s = md5(vUser.getPassword());
        vUser.setPassword(s);

        sysService.addUser(vUser);
        // 添加权限需要获取用户数据库自增 id值对 user_role中间表进行操作
        sysService.addRole(vUser.getUid(),Integer.parseInt(vUser.getRoleName()));
        return new JsonResult(1,null);
    }

    @ResponseBody
    @RequestMapping("/changeAuthority.do")
    public JsonResult updateRoleById(String userName, Integer rid) {
        User user = userService.login(userName);
        sysService.updateRoleById(user.getUid(),rid);
        return new JsonResult(1,null);
    }

    /**
     * 私有化方法加密用户密码
     * @param password 用户原始密码
     * @return 加密后的密码
     */
    private String md5(String password) {
        String s = new SimpleHash("md5", password, "examsys", 1).toHex();
        return s;
    }
}
