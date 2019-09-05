package com.qfedu.examsys.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.Page;
import com.qfedu.examsys.common.JsonResult;
import com.qfedu.examsys.entity.Shit;
import com.qfedu.examsys.service.AnotherService;
import com.qfedu.examsys.utils.JsonUtils;
import com.qfedu.examsys.vo.Another;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
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

    @ResponseBody
    @RequestMapping("/shit")
    public Map<String, String> findOneAM(Integer sid) {
        String answer = anotherService.findOneAM(sid);
//        Map<String,String> map = new HashMap<>();
//        String[] arr = answer.split("_");
//        for (int i = 0; i < arr.length; i++) {
//            String s = arr[i].substring(0, arr[i].indexOf("&"));
//            String s1 = arr[i].substring(arr[i].indexOf("&") + 1);
//            map.put(s,s1);
//        }
        ObjectMapper mapper = new ObjectMapper();
        Map<String,String> map = null;
        try {
            map = mapper.readValue(answer, new TypeReference<Map<String, String>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;

    }
}
