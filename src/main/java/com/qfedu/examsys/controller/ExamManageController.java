package com.qfedu.examsys.controller;

import com.github.pagehelper.Page;
import com.qfedu.examsys.common.JsonResult;
import com.qfedu.examsys.entity.ExamManage;
import com.qfedu.examsys.service.ExamManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ExamManageController
 * @Description 考场信息控制层
 * @Author GK
 * @Date 2019/8/30   15:57
 */

@Controller
@ResponseBody
public class ExamManageController {

    @Autowired(required = false)
    private ExamManageService examManageService;

    @PostMapping("/addEM.do")
    public JsonResult addEms(ExamManage examManage) {

        examManageService.addEms(examManage);

        return new JsonResult(1, null);
    }

    @RequestMapping("/deleteEM.do")
    public JsonResult deleteEms(Integer eid) {

        examManageService.deleteEmsById(eid);

        return new JsonResult(1, null);
    }

    @PostMapping("/updateEM.do")
    public JsonResult updateEms(ExamManage examManage) {

        examManageService.updateEms(examManage);

        return new JsonResult(1, null);
    }

    @GetMapping("/queryEM.do")
    public JsonResult findOne(Integer eid) {

        ExamManage ems = examManageService.findEmsById(eid);

        return new JsonResult(1, ems);
    }

    @RequestMapping("/pageEM.do")
    public Map<String, Object> findAllByPage(Integer page, Integer limit) {

        List<ExamManage> list = examManageService.findAllEmsByPage(page, limit);

        long total = ((Page)list).getTotal();

        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", total);
        map.put("data", list);

        return map;
    }
}