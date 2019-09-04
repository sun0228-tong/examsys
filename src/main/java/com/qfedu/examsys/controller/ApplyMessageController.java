package com.qfedu.examsys.controller;

import com.github.pagehelper.Page;
import com.qfedu.examsys.common.JsonResult;
import com.qfedu.examsys.entity.ApplyMessage;
import com.qfedu.examsys.entity.ExamManage;
import com.qfedu.examsys.service.ApplyMessageService;
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
 * @ClassName ApplyMessageController
 * @Description 报名信息控制层
 * @Author GK
 * @Date 2019/8/30   15:57
 */
@Controller
@ResponseBody
public class ApplyMessageController {

    @Autowired(required = false)
    private ApplyMessageService applyMessageService;

    @PostMapping("/addAM.do")
    public JsonResult addAms(ApplyMessage applyMessage) {

        applyMessageService.addAms(applyMessage);

        return new JsonResult(1, null);
    }

    @RequestMapping("/deleteAM.do")
    public JsonResult deleteAms(Integer aid) {

        applyMessageService.deleteAmsById(aid);

        return new JsonResult(1, null);
    }

    @PostMapping("/updateAM.do")
    public JsonResult updateAms(ApplyMessage applyMessage) {

        applyMessageService.updateAms(applyMessage);

        return new JsonResult(1, null);
    }

    @GetMapping("/queryAM.do")
    public JsonResult findOne(Integer aid) {

        ApplyMessage ams = applyMessageService.findAmsById(aid);

        return new JsonResult(1, ams);
    }

    @RequestMapping("/pageAM.do")
    public Map<String, Object> findAll(Integer page, Integer limit) {

        List<ApplyMessage> list = applyMessageService.findAllAms(page, limit);

        long total = ((Page)list).getTotal();

        Map<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", total);
        map.put("data", list);

        return map;
    }
}