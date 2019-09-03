package com.qfedu.examsys.controller;

import com.qfedu.examsys.common.JsonResult;
import com.qfedu.examsys.entity.Student;
import com.qfedu.examsys.service.StudentService;
import com.qfedu.examsys.utils.MailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName StudentController
 * @Description 学生信息管理的控制层
 * @Author GK
 * @Date 2019/8/29   14:59
 */
@Controller
@ResponseBody
@RequestMapping("/stu")
public class StudentController {

    @Autowired(required = false)
    private StudentService studentService;

    @PostMapping("/addSTU.do")
    public JsonResult addStus(Student student) {

        studentService.addStus(student);

        return new JsonResult(1, null);
    }

    @RequestMapping("/deleteSTU.do")
    public JsonResult deleteStus(Integer sid) {

        studentService.deleteStusById(sid);

        return new JsonResult(1, null);
    }

    @PostMapping("/updateSTU.do")
    public JsonResult updateStus(Student student) {

        studentService.updateStus(student);

        return new JsonResult(1, null);
    }

    @GetMapping("/querySTU.do")
    public JsonResult findById(Integer sid) {

        Student stu = studentService.findStusById(sid);

        return new JsonResult(1, stu);
    }

    @RequestMapping("/listSTU.do")
    public JsonResult findAllStus() {

        List<Student> list = studentService.findAllStus();

        return new JsonResult(1, list);
    }

    @RequestMapping("/emailSTU.do")
    public JsonResult findAllEmail() {

        List<String> list = studentService.findAllEmail();

        for (String email : list) {
            new MailUtil(email).run();
        }

        return new JsonResult(1, "考试信息已发送");
    }
}