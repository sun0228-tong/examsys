package com.qfedu.examsys.controller;

import com.qfedu.examsys.entity.ShortManage;
import com.qfedu.examsys.service.ShortManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/shortManage")
public class ShortManageController {
    @Autowired
    private ShortManageService shortManageService;

    @RequestMapping("/submit.do")
    public String submitVolume(ShortManage shortManage) {
        shortManageService.add(shortManage);
        return "1";
    }
}
