package com.qfedu.examsys.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qfedu.examsys.common.JsonResult;
import com.qfedu.examsys.entity.ShortManage;
import com.qfedu.examsys.service.JudgecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/judge")
public class JudgecController {
    @Autowired
    private JudgecService judgecService;

    @RequestMapping("/toUpdatePage.do")
    public JsonResult toUpdatePage(Integer sid) {
        ShortManage shortManage;
        synchronized (this) {
            shortManage = judgecService.toUpdatePageFind(sid);
        }

        if (shortManage == null) {
            return new JsonResult(1, "该学生试题已被批改");
        }

        return new JsonResult(0, shortManage);
    }

    @RequestMapping("/toUpdatePage1.do")
    public JsonResult toUpdatePage1(Integer sid) {
        ShortManage shortManage;
        synchronized (this) {
            shortManage = judgecService.toUpdatePageFind(sid);
        }

        if (shortManage == null) {
            return new JsonResult(-1, "该学生试题已被批改");
        }

        Map<String, String> map = null;

        String answer = shortManage.getAnswer();
        ObjectMapper mapper = new ObjectMapper();
        try {
            map = mapper.readValue(answer,new TypeReference<Map<String,String>>(){
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new JsonResult(shortManage.getAid(), map);
    }

    @RequestMapping("/sidArray.do")
    public List<Integer> sidArray(Integer sid) {
        Integer subjectId = judgecService.shits(sid).getSubjectId();
        return judgecService.sidArray(sid, subjectId);
    }
}
