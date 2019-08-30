package com.qfedu.examsys.controller;

import com.qfedu.examsys.common.JsonResult;
import com.qfedu.examsys.entity.Authority;
import com.qfedu.examsys.service.SysService;
import com.qfedu.examsys.vo.VAuthority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
@RequestMapping("/sys")
public class SysController {

    @Autowired
    private SysService sysService;

    @ResponseBody
    @RequestMapping("/findAuthorityById.do")
    public List<VAuthority> findAuthorityById(Integer uid) {
        List<VAuthority> list = sysService.findAuthorityById(uid);

        return list;
    }
}
