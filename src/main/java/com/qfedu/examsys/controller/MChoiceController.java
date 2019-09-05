package com.qfedu.examsys.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qfedu.examsys.common.JsonResult;
import com.qfedu.examsys.entity.MChoiceQuestion;
import com.qfedu.examsys.service.MChoiceService;
import com.qfedu.examsys.utils.ExcelUtils;
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
 * @Name MChoiceController
 * @Author Yama
 * @Date 2019/9/1 13:58
 * @Version V1.0
 */
@Controller
@RequestMapping("/mChoice")
public class MChoiceController {

    @Autowired
    private MChoiceService mChoiceService;

    /**
     * 跳转到导入多选题页面
     * @return
     */
    @RequestMapping("/skipMChoice")
    public String skipMChoiceTitle() {
        return "addMChoice";
    }

    /**
     * 批量插入多选题试题
     * @param upMChoice
     * @return
     */
    @RequestMapping("/importMChoiceTitle")
    @ResponseBody
    public JsonResult importMChoice(@RequestParam("file") MultipartFile upMChoice) {
        try {
            // 获取上传文件的输入流对象
            InputStream inputStream = upMChoice.getInputStream();
            // 获取上传文件名称
            String filename = upMChoice.getOriginalFilename();
            // 获取数据行数
            List<Map<String, Object>> list = ExcelUtils.readExcel(filename, inputStream);

            ObjectMapper objectMapper = new ObjectMapper();

            String jsonStr = objectMapper.writeValueAsString(list);
            // 将 json 格式的字符串转为指定类型的对象
            List<MChoiceQuestion> list1 = objectMapper.readValue(jsonStr, new TypeReference<List<MChoiceQuestion>>(){});

            mChoiceService.addMChoiceTitle(list1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new JsonResult(1, null);
    }

    @RequestMapping("/skipListMChoice")
    public String skipListMChoice() {
        return "listMChoice";
    }

    /**
     * 查询所有多选题信息
     * @param subjectName 需要模糊查询，传入的参数是一个学科名称
     * @param page
     * @param limit
     * @return 返回查询到的信息
     */
    @RequestMapping("/mChoiceAll")
    @ResponseBody
    public Map<String, Object> findAll(String subjectName, Integer page, Integer limit) {
        Map<String, Object> map = mChoiceService.findAll(subjectName, page, limit);
        return map;
    }

    /**
     * 查询一条信息
     * @param mid 传入的参数是一个Id
     * @return 返回的是查询到的数据
     */
    @RequestMapping("/findById")
    @ResponseBody
    public JsonResult findById(Integer mid) {
        MChoiceQuestion mChoice = mChoiceService.findById(mid);
        return new JsonResult(1, mChoice);
    }

    /**
     * 删除一条 mChoice_Question 的信息
     * @param mid 传入的信息是一个ID
     * @return 成功返回1
     */
    @RequestMapping("/deleteMChoice")
    @ResponseBody
    public JsonResult deleteMChoice(Integer mid) {
        mChoiceService.deleteMChoice(mid);
        return new JsonResult(1, null);
    }

    @RequestMapping("/skipModifyChoice")
    public String skipModifyChoice() {
        return "modifyMChoice";
    }

    /**
     * 修改 MChoiceQuestion 的一条信息
     * @param mChoiceTitle 传入的参数 MChoiceQuestion 类对象
     * @return 修改成功返回 1
     */
    @RequestMapping("/modifyMChoice")
    @ResponseBody
    public JsonResult modifyMChoice(MChoiceQuestion mChoiceTitle) {
        mChoiceService.modifyMChoice(mChoiceTitle);
        return new JsonResult(1, null);
    }

    /**
     * 跳转到查看一道多选题页面
     * @return 返回到多选题页面
     */
    @RequestMapping("/skipLookAtAChoice")
    public String skipLookAtAMChoice() {
        return "lookAtAMChoice";
    }
}
