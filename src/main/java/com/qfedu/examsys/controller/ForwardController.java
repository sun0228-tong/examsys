package com.qfedu.examsys.controller;

import com.qfedu.examsys.common.JsonResult;
import com.qfedu.examsys.entity.Student;
import com.qfedu.examsys.service.StudentService;
import com.qfedu.examsys.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/api")
public class ForwardController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private StudentService studentService;

    @RequestMapping("/login.do")
    @ResponseBody
    public JsonResult login(String name, String password) {
        Student student = studentService.login(name, password);
        JsonResult jsonResult = null;

        if (student != null) {

            String token = MD5Utils.md5(name + "examsys");

            jsonResult = new JsonResult(1,token);

            redisTemplate.opsForValue().set(token,name);
        } else {
            jsonResult = new JsonResult(0,"账号或密码错误");
        }
        return jsonResult;
    }

    @RequestMapping("/logout.do")
    @ResponseBody
    public JsonResult logout(String name) {
        redisTemplate.delete(name);
        return new JsonResult(1,null);
    }

}
