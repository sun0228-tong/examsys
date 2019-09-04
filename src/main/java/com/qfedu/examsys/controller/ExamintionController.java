package com.qfedu.examsys.controller;

import com.qfedu.examsys.common.Testpaper;
import com.qfedu.examsys.service.ExaminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/exa")
public class ExamintionController {

    @Autowired
    private ExaminationService examinationService;

    @RequestMapping("examination.do")
    public Testpaper examination(Integer subjectId,String token) {
        return examinationService.generate(subjectId);
    }
}
