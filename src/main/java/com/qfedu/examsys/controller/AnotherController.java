package com.qfedu.examsys.controller;

import com.github.pagehelper.Page;
import com.qfedu.examsys.service.AnotherService;
import com.qfedu.examsys.vo.Another;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AnotherController {

    @Autowired
    private AnotherService anotherService;

    @ResponseBody
    @RequestMapping("/another")
    public Map<String, Object> findAllSM(Integer page, Integer limit, Integer subjectId) {
        List<Another> list = anotherService.findAllSM(page, limit, subjectId);

        long total = ((Page)list).getTotal();
        Map<String, Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",total);
        map.put("data",list);

        return map;
    }
}
