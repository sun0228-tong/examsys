package com.qfedu.examsys.controller;

import com.github.pagehelper.Page;
import com.qfedu.examsys.common.JsonResult;
import com.qfedu.examsys.entity.Student;
import com.qfedu.examsys.service.ForwardService;
import com.qfedu.examsys.service.StudentService;
import com.qfedu.examsys.utils.MD5Utils;
import com.qfedu.examsys.vo.VApply;
import com.qfedu.examsys.vo.VScore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api")
public class ForwardController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private StudentService studentService;

    @Autowired
    private ForwardService forwardService;

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

    @ResponseBody
    @RequestMapping("/findApplyInfo")
    public Map<String, Object> findApplyInfo(String tokenStr, Integer page, Integer limit) {
        String name = redisTemplate.opsForValue().get(tokenStr);
        List<VApply> list = forwardService.findApplyInfoByName(name, page, limit);

        Map<String, Object> map = new HashMap<>();
        long total = ((Page)list).getTotal();
        map.put("code",0);
        map.put("msg","");
        map.put("count",total);
        map.put("data",list);

        return map;
    }

    @ResponseBody
    @RequestMapping("/findScoreInfo")
    public Map<String, Object> findScoreInfo(String tokenStr, Integer page, Integer limit) {
        String name = redisTemplate.opsForValue().get(tokenStr);
        List<VScore> list = forwardService.findScoreInfoByName(name, page, limit);

        Map<String, Object> map = new HashMap<>();
        long total = ((Page)list).getTotal();
        map.put("code",0);
        map.put("msg","");
        map.put("count",total);
        map.put("data",list);

        return map;
    }

}
