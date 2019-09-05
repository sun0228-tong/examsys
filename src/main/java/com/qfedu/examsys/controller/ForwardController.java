package com.qfedu.examsys.controller;

import com.github.pagehelper.Page;
import com.qfedu.examsys.common.JsonResult;
import com.qfedu.examsys.entity.ApplyMessage;
import com.qfedu.examsys.entity.ExamManage;
import com.qfedu.examsys.entity.Student;
import com.qfedu.examsys.entity.Subject;
import com.qfedu.examsys.service.*;
import com.qfedu.examsys.utils.MD5Utils;
import com.qfedu.examsys.vo.VApply;
import com.qfedu.examsys.vo.VScore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
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
    private SubjectService subjectService;

    @Autowired
    private ForwardService forwardService;

    @Autowired
    private ApplyMessageService applyMessageService;

    @Autowired
    private ExamManageService examManageService;

    @Autowired
    private ScoreManagementService scoreManagementService;

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
        Date currentTime = new Date();
        List<VApply> list = forwardService.findApplyInfoByName(name, currentTime,page, limit);

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
    public Map<String, Object> findScoreInfo(Integer subjectId, Date examStart, Date examEnd, String tokenStr, Integer page, Integer limit) {
        String name = redisTemplate.opsForValue().get(tokenStr);
        List<VScore> list = forwardService.findScoreInfoByName(subjectId,examStart,examEnd,name, page, limit);

        Map<String, Object> map = new HashMap<>();
        long total = ((Page)list).getTotal();
        map.put("code",0);
        map.put("msg","");
        map.put("count",total);
        map.put("data",list);

        return map;
    }

    @RequestMapping("/findExamInfo")
    @ResponseBody
    public Map<String, Object> findExamInfo(Integer page, Integer limit) {

        List<ExamManage> list = examManageService.findAllEmsByPage(page, limit);

        long total = ((Page)list).getTotal();

        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", total);
        map.put("data", list);

        return map;
    }

    @RequestMapping("/studentApply")
    @ResponseBody
    public JsonResult studentApply(String tokenStr, Integer examManageId, String subjectName,Date applyStart, Date applyEnd) {
        String name = redisTemplate.opsForValue().get(tokenStr);
        JsonResult jsonResult = null;
        Date currentTime = new Date();

        Student student = studentService.findByStudentName(name);
        Subject subject = subjectService.findBySubjectName(subjectName);

        ApplyMessage applyMessage = new ApplyMessage();
        applyMessage.setExamManageId(examManageId);
        applyMessage.setStudentId(student.getSid());
        applyMessage.setSubjectId(subject.getSid());

        ApplyMessage applyMessage1 = examManageService.findByExamManageId(examManageId,student.getSid());

        if (currentTime.getTime() <= applyStart.getTime()) {
            jsonResult = new JsonResult(0,"未到报名时间");
        } else if (currentTime.getTime() > applyEnd.getTime()) {
            jsonResult = new JsonResult(0,"报名时间已过");
        } else {
            // 判断是否重复报名
            if (applyMessage1 == null) {
                applyMessageService.addAms(applyMessage);
                jsonResult = new JsonResult(1,null);
            } else {
                jsonResult = new JsonResult(0,"不能重复报名");
            }
        }
        return jsonResult;
    }

    @ResponseBody
    @RequestMapping("/findAllSubject")
    public JsonResult findAllSubject() {
        List<Subject> list = subjectService.findAll();
        return new JsonResult(1,list);
    }

    @ResponseBody
    @RequestMapping("/delStudentScore")
    public JsonResult delStudentScore(Integer sid) {
         scoreManagementService.delScoreById(sid);
         return new JsonResult(1,null);
    }

    @ResponseBody
    @RequestMapping("/checkExamStatus")
    public JsonResult checkExamStatus(Date examStart, Date examEnd, Integer aid) {
        Date currentTime = new Date();
        JsonResult jsonResult = null;
        ApplyMessage applyMessage = applyMessageService.findAmsById(aid);

        if (currentTime.getTime() < examStart.getTime()) {
            jsonResult = new JsonResult(0,"未到考试时间");
        } else if (currentTime.getTime() > examEnd.getTime()) {
            jsonResult = new JsonResult(0,"考试已结束");
        } else {
            jsonResult = new JsonResult(1,applyMessage);
        }

        return jsonResult;
    }

}
