package com.qfedu.examsys.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qfedu.examsys.entity.ChoiceQuestion;
import com.qfedu.examsys.utils.ExcelUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

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

    /**
     * 跳转到试题管理页面
     * @return 返回试题管理页面
     */
    @RequestMapping("/titleManagement")
    public String title(){
        return "titleManagement";
    }

    @RequestMapping("/importChoiceTitle")
    public String importChoice(@RequestParam MultipartFile upChoice) {
        // 获取上传文件的输入流对象
        try {
            InputStream inputStream = upChoice.getInputStream();

            String filename = upChoice.getOriginalFilename();

            List<Map<String, Object>> list = ExcelUtils.readExcel(filename, inputStream);

            ObjectMapper objectMapper = new ObjectMapper();

            String jsonStr = objectMapper.writeValueAsString(list);
            // 将 json 格式的字符串转为指定类型的对象
            List<ChoiceQuestion> list1 = objectMapper.readValue(jsonStr, new TypeReference<List<ChoiceQuestion>>() {});

            System.out.println(list1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }

    @RequestMapping("/Choice")
    public String title2(){
        return "listChoice";
    }


}
