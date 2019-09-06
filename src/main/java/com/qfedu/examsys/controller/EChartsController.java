package com.qfedu.examsys.controller;

import com.qfedu.examsys.common.JsonResult;
import com.qfedu.examsys.entity.BGSubjectScore;
import com.qfedu.examsys.entity.BGExamScore;
import com.qfedu.examsys.entity.FMExamScore;
import com.qfedu.examsys.service.EChartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.bind.util.JAXBSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName FExamScoreController
 * @Description 折线图控制层
 * @Author GK
 * @Date 2019/9/3   17:27
 */
@Controller
@ResponseBody
public class EChartsController {

    @Autowired
    private EChartsService eChartsService;

    @RequestMapping("/fes.do")
    public Map<String, List> FExamScore() {

        List<BGExamScore> list = eChartsService.findExamAndScore();
        List<String> eid = new ArrayList<>();
        List<Integer> score = new ArrayList<>();

        for (BGExamScore fExamScore : list) {
            eid.add("第" + fExamScore.getEid() + "考场");
            score.add(fExamScore.getScore());
        }

        Map<String, List> map = new HashMap<>();
        map.put("eid", eid);
        map.put("score", score);

        return map;
    }

    @RequestMapping("/bgss.do")
    public Map<String, List> BGSubjectScore() {

        List<BGSubjectScore> list = eChartsService.findSubjectNameAndScore();
        List<String> subjectName = new ArrayList<>();
        List<Integer> score = new ArrayList<>();

        for (BGSubjectScore bGSubjectScore : list) {
            subjectName.add(bGSubjectScore.getSubjectName());
            score.add(bGSubjectScore.getScore());
        }

        Map<String, List> map = new HashMap<>();
        map.put("subjectName", subjectName);
        map.put("score", score);

        return map;
    }

    @RequestMapping("/api/fmes.do")
    public Map<String, List> FMExamScore(Integer eid) {

        List<FMExamScore> list = eChartsService.findStudentNameAndScore(eid);

        List<String> studentName = new ArrayList<>();
        List<Integer> score = new ArrayList<>();
        for (FMExamScore fmExamScore : list) {
            studentName.add(fmExamScore.getStudentName());
            score.add(fmExamScore.getScore());
        }
        Map<String, List> map = new HashMap<>();
        map.put("studentName", studentName);
        map.put("score", score);
        return map;

    }

    @RequestMapping("/api/eid.do")
    public JsonResult findEid() {

        List<FMExamScore> list = eChartsService.findStudentNameAndScoreById();

        return new JsonResult(1, list);
    }
}