package com.qfedu.examsys.controller;

import com.qfedu.examsys.common.JsonResult;
import com.qfedu.examsys.entity.ScoreManage;
import com.qfedu.examsys.entity.ShortManage;
import com.qfedu.examsys.service.JudgecService;
import com.qfedu.examsys.service.ScoreManageService;
import com.qfedu.examsys.service.ShortManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subScore")
public class ScoreManageController {
    @Autowired
    private ScoreManageService scoreManageService;

    @Autowired
    private JudgecService judgecService;

    @RequestMapping("/subm.do")
    public JsonResult subm(ScoreManage scoreManage1, Integer aid1, Integer score1, Integer otherScore) {
        if (!aid1.equals(0)) {
            ShortManage manage = judgecService.findByAid(aid1);
            ScoreManage scoreManage = new ScoreManage();
            scoreManage.setApplyManageId(aid1);
            scoreManage.setStudentId(manage.getStudentId());
            scoreManage.setScore(score1 + manage.getOtherScore());
            scoreManageService.subm(scoreManage);
            judgecService.updateHasChecking(judgecService.findByAid(scoreManage.getApplyManageId()).getSid());
            return new JsonResult(1, null);
        } else {
            scoreManage1.setScore(otherScore + score1);
            scoreManageService.subm(scoreManage1);
            judgecService.updateHasChecking(judgecService.findByAid(scoreManage1.getApplyManageId()).getSid());
            return new JsonResult(1, null);
        }
    }
}
