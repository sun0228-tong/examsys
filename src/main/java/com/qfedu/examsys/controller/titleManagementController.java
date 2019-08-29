package com.qfedu.examsys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description TODO
 * @Name titleManagementController
 * @Author Yama
 * @Date 2019/8/29 10:31
 * @Version V1.0
 */
@Controller
@RequestMapping("/title")
public class titleManagementController {

    @RequestMapping("/titleManagement")
    public String title(){
        return "titleManagement";
    }

    @RequestMapping("/Choice")
    public String title2(){
        return "listChoice";
    }


}
