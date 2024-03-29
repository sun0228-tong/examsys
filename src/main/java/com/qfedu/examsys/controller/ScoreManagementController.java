package com.qfedu.examsys.controller;

import com.qfedu.examsys.service.impl.ScoreManagementServiceImpl;
import com.qfedu.examsys.vo.VScoreManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @ClassName MarkPapersController 判卷模块控制层
 * @Description 控制层考试信息的提交，对提交的考生答案同数据库中的答案进行比对并统计出该学生的试卷总分数
 * @Author wangzhendong
 * @Date 2019/8/29
 */
@Controller
public class ScoreManagementController {

    @Autowired
    private ScoreManagementServiceImpl scoreManagementService;

    @RequestMapping("/scoreInquiry/findAllScoreManage.do")
    @ResponseBody
    public Map<String, Object> findAllScoreManage(Integer page, Integer limit, String studentName, String subjectName, Integer eid) {
        return scoreManagementService.findAllScoreManage(page, limit, studentName, subjectName, eid);
    }

    @RequestMapping("/scoreInquiry/findByIdScoreManage.do")
    @ResponseBody
    public Map<String, Object> findByIdScoreManage(Integer sid) {
        return scoreManagementService.findByIdScoreManage(sid);
    }

    @RequestMapping("/scoreInquiry/findAllSubject.do")
    @ResponseBody
    public Map<String, Object> findAllSubject() {
        return scoreManagementService.findAllSubject();
    }

    @RequestMapping("/scoreInquiry/updateScoreManage.do")
    @ResponseBody
    public Map<String, Object> updateScoreManage(VScoreManage vScoreManage) {
        return scoreManagementService.updateScoreManage(vScoreManage);
    }
}
