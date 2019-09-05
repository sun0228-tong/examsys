package com.qfedu.examsys.controller;

import com.qfedu.examsys.common.JsonResult;
import com.qfedu.examsys.entity.ShortManage;
import com.qfedu.examsys.service.JudgecService;
import com.qfedu.examsys.service.ShortManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/judge")
public class JudgecController {
    @Autowired
    private JudgecService judgecService;

    @Autowired
    private ShortManageService shortManageService;

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

    @RequestMapping("/sidArray.do")
    public List<Integer> sidArray(Integer sid) {
        Integer subjectId = judgecService.shits(sid).getSubjectId();
        return judgecService.sidArray(sid, subjectId);
    }
}
