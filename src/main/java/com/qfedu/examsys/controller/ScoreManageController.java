package com.qfedu.examsys.controller;

import com.qfedu.examsys.common.JsonResult;
import com.qfedu.examsys.entity.ScoreManage;
import com.qfedu.examsys.service.ScoreManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subScore")
public class ScoreManageController {
    @Autowired
    private ScoreManageService scoreManageService;

    @RequestMapping("/subm.do")
    public JsonResult subm(ScoreManage scoreManage) {
        scoreManageService.subm(scoreManage);
        return new JsonResult(1,null);
    }
}
