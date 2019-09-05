package com.qfedu.examsys.controller;

import com.qfedu.examsys.common.JsonResult;
import com.qfedu.examsys.entity.Subject;
import com.qfedu.examsys.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Name SubjectController
 * @Author Yama
 * @Date 2019/8/31 14:43
 * @Version V1.0
 */
@Controller
@ResponseBody
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    /**
     * 查询所有学科信息，模糊查询使用
     * @return 返回查询到的记录
     */
    @RequestMapping("/findBySubjectAll")

    public JsonResult findBySubjectAll() {

        List<Subject> list = subjectService.findAll();
        return new JsonResult(1, list);
    }

    /**
     * 查询一条学科信息
     * @param sid 传入的参数是一个 学科Id
     * @return 查询到返回 1
     */
    @RequestMapping("/findById")
    @ResponseBody
    public JsonResult findById(Integer sid) {
        Subject subject = subjectService.findById(sid);
        return new JsonResult(1, subject);
    }

    /**
     * 添加一条学科信息
     * @param subject 传入的参数是 Subject 类对象
     * @return 添加成功返回 1
     */
    @RequestMapping("/addSubject")
    @ResponseBody
    public JsonResult addSubject(Subject subject) {
        subjectService.addSubject(subject);
        return new JsonResult(1, null);
    }

    /**
     * 修改一条学科信息
     * @param subject 传入的参数是一个 Subject 类对象
     * @return 修改成功返回 1
     */
    @RequestMapping("/modifySubject")
    @ResponseBody
    public JsonResult modifySubject(Subject subject) {
        subjectService.modifySubject(subject);
        return new JsonResult(1, null);
    }

    /**
     * 跳转到 modifySubject
     * @return 返回到 modifySubject
     */
    @RequestMapping("/skipModifySubject")
    public String skipModifySubject() {
        return "modifySubject";
    }

    /**
     * 跳转到 addSubject 页面
     * @return 返回到 addSubject 页面
     */
    @RequestMapping("/skipAddSubject")
    public String skipAddSubject() {
        return "addSubject";
    }

    /**
     * 跳转到 listSubject 页面
     * @return 返回到 listSubject 页面
     */
    @RequestMapping("/skipSubject")
    public String skipListSubject() {
        return "listSubject";
    }


    /**
     * 分页查询所有科目
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("/findBySubject")
    @ResponseBody
    public Map<String, Object> findBySubject(Integer page, Integer limit) {
        Map<String, Object> map = subjectService.findBySubject(page, limit);
        return map;
    }
}
