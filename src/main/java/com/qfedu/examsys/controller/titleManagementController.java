package com.qfedu.examsys.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qfedu.examsys.common.JsonResult;
import com.qfedu.examsys.entity.ChoiceQuestion;
import com.qfedu.examsys.service.ChoiceService;
import com.qfedu.examsys.utils.ExcelUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @Autowired
    private ChoiceService choiceService;

    /**
     * 跳转到试题管理页面
     * @return 返回试题管理页面
     */
    @RequestMapping("/titleManagement")
    public String title(){
        return "titleManagement";
    }

    /**
     * 批量导入选择题Excel文件
     * @param upChoice 传入的是html中input标签的name
     * @return
     */
    @RequestMapping("/importChoiceTitle")
    public String importChoice(@RequestParam MultipartFile upChoice) {
        // 获取上传文件的输入流对象
        try {
            InputStream inputStream = upChoice.getInputStream();
            // 获取上传文件名称
            String filename = upChoice.getOriginalFilename();
            // 获取数据行数
            List<Map<String, Object>> list = ExcelUtils.readExcel(filename, inputStream);

            ObjectMapper objectMapper = new ObjectMapper();

            String jsonStr = objectMapper.writeValueAsString(list);
            // 将 json 格式的字符串转为指定类型的对象
            List<ChoiceQuestion> list1 = objectMapper.readValue(jsonStr, new TypeReference<List<ChoiceQuestion>>(){});

            choiceService.addChoiceTitle(list1);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }

    /**
     * 跳转到导入选择题页面
     * @return 返回到 addChoice.html页面
     */
    @RequestMapping("/Choice")
    public String title2(){
        return "addChoice";
    }

    /**
     * 跳转到查看所有信息页面
     * @return 返回到 listChoice.html
     */
    @RequestMapping("/skipChoice")
    public String skipListChoice() {
        return "listChoice";
    }

    @RequestMapping("/choiceAll")
    @ResponseBody
    public Map<String, Object> findByChoiceAll(Integer page, Integer limit) {
        Map<String, Object> map = choiceService.findByChoiceAll(page, limit);
        return map;
    }

}
