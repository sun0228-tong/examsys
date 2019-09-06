package com.qfedu.examsys.controller;

import com.qfedu.examsys.entity.ShortManage;
import com.qfedu.examsys.entity.Student;
import com.qfedu.examsys.service.JudgecService;
import com.qfedu.examsys.service.ShortManageService;
import com.qfedu.examsys.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/shortManage")
public class ShortManageController {
    @Autowired
    private ShortManageService shortManageService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private StudentService studentService;

    @Autowired
    private JudgecService judgecService;

    @RequestMapping("/submit.do")
    public String submitVolume(ShortManage shortManage,String tokenStr) {
        String name = redisTemplate.opsForValue().get(tokenStr);
        Student student = studentService.findByStudentName(name);
        shortManage.setStudentId(student.getSid());
        shortManageService.add(shortManage);
        judgecService.updateHasChecking(shortManage.getSid());
        return "{\"info\":\"提交成功\"}";
    }
}
