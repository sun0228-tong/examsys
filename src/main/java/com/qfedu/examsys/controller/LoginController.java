package com.qfedu.examsys.controller;

import com.qfedu.examsys.common.JsonResult;
import com.qfedu.examsys.entity.User;
import com.qfedu.examsys.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "loginshit";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult login(String userName, String password) {

        User user = userService.login(userName);

        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);

        Subject subject = SecurityUtils.getSubject();

        JsonResult jsonResult = null;

        try {
            subject.login(token);
            jsonResult = new JsonResult(1,user.getUid());
        } catch (AuthenticationException e) {
            jsonResult = new JsonResult(0,null);
        }
        return jsonResult;
    }

}
