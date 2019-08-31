package com.qfedu.examsys.controller;

import com.qfedu.examsys.common.JsonResult;
import com.qfedu.examsys.dao.SubjectDao;
import com.qfedu.examsys.entity.Subject;
import com.qfedu.examsys.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Description TODO
 * @Name SubjectController
 * @Author Yama
 * @Date 2019/8/31 14:43
 * @Version V1.0
 */
@Controller
@RequestMapping("/subject")
public class SubjectController {

    @Autowired(required = false)
    private SubjectService subjectService;

    /**
     * 查询所有学科信息，模糊查询使用
     * @return 返回查询到的记录
     */
    @RequestMapping("/findBySubjectAll")
    @ResponseBody
    public JsonResult findBySubjectAll() {
        List<Subject> list = subjectService.findAll();
        return new JsonResult(1, list);
    }
}
