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
import java.sql.SQLException;
import java.util.Iterator;
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
    @ResponseBody
    public JsonResult importChoice(@RequestParam("file") MultipartFile upChoice) {
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

        } catch (Exception e) {
            e.getMessage();
        }

        return new JsonResult(1, null);
    }

    /**
     * 跳转到导入选择题页面
     * @return 返回到 addChoice.html页面
     */
    @RequestMapping("/choice")
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

    /**
     * 查询所有单选题信息
     * @param subjectName
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("/choiceAll")
    @ResponseBody
    public Map<String, Object> findByChoiceAll(String subjectName, Integer page, Integer limit) {
        Map<String, Object> map = choiceService.findByChoiceAll(subjectName, page, limit);
        return map;
    }

    /**
     * 查询一条记录
     * @param cid 传入的参数是一选择题id
     * @return 查询到返回一条记录
     */
    @RequestMapping("/findByChoiceId")
    @ResponseBody
    public JsonResult findByChoiceId(Integer cid) {
        ChoiceQuestion choice = choiceService.findById(cid);
        return new JsonResult(1, choice);
    }

    /**
     * 删除一条选择题
     * @param cid 传入的参数是选择题ID
     * @return 删除成功返回1，未成功返回0
     */
    @RequestMapping("/deleteChoice")
    @ResponseBody
    public JsonResult deleteChoice(Integer cid) {
        choiceService.deleteChoice(cid);
        return new JsonResult(1, null);
    }

    /**
     * 修改一条选择题信息
     * @param choiceQuestion 传入的对象是一个 choiceQuestion 类对象
     * @return 修改成功返回1，不成功返回0
     */
    @RequestMapping("/modifyChoice")
    @ResponseBody
    public JsonResult updateChoice(ChoiceQuestion choiceQuestion) {
        choiceService.updateChoice(choiceQuestion);
        return new JsonResult(1, null);
    }

    /**
     * 跳转到修改信息页面
     * @return 返回到修改信息页面
     */
    @RequestMapping("/skipModifyChoice")
    public String skipModifyChoice() {
        return "modifyChoice";
    }

    /**
     * 跳转到查询一道题目界面
     * @return 返回到查询一道题目界面
     */
    @RequestMapping("/skipLoopAtAChoice")
    public String skipLookAtAChoice() {
        return "lookAtAChoice";
    }

}
