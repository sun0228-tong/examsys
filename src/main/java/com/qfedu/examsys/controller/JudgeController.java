package com.qfedu.examsys.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qfedu.examsys.common.JsonResult;
import com.qfedu.examsys.entity.JudgeQuestion;
import com.qfedu.examsys.service.JudgeService;
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
 * @Name JudgeController
 * @Author Yama
 * @Date 2019/9/1 14:50
 * @Version V1.0
 */
@Controller
@RequestMapping("/judge")
public class JudgeController {
    @Autowired
    private JudgeService judgeService;

    /**
     * 跳转到上传判断题页面
     * @return
     */
    @RequestMapping("/skipJudge")
    public String skipJudge() {
        return "addJudge";
    }

    /**
     * 导入判断题
     * @param upJudge
     * @return
     */
    @RequestMapping("/importJudge")
    @ResponseBody
    public JsonResult importJudge(@RequestParam("file") MultipartFile upJudge) {
        try {
            // 获取上传文件对象的输入流
            InputStream inputStream = upJudge.getInputStream();
            // 获取上传文件名称
            String filename = upJudge.getOriginalFilename();
            // 获取数据的行数
            List<Map<String, Object>> list = ExcelUtils.readExcel(filename, inputStream);

            ObjectMapper objectMapper = new ObjectMapper();

            String jsonStr = objectMapper.writeValueAsString(list);
            List<JudgeQuestion> list1  = objectMapper.readValue(jsonStr, new TypeReference<List<JudgeQuestion>>() {});

            judgeService.addJudgeTitle(list1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new JsonResult(1, null);
    }

    /**
     * 跳转到展示所有判断题页面
     * @return
     */
    @RequestMapping("/skipListJudge")
    public String skipListJudge() {
        return "listJudge";
    }

    /**
     * 查询所有判断题信息
     * @param subjectName 传入的参数是科目名称，模糊查询使用
     * @param limit 分页
     * @param page
     * @return 成功返回查询到的信息
     */
    @RequestMapping("/listJudge")
    @ResponseBody
    public Map<String, Object> findAll(String subjectName, Integer page, Integer limit) {
        Map<String, Object> map = judgeService.findAll(subjectName, page, limit);
        return map;
    }

    /**
     * 跳转到修改信息页面
     * @return
     */
    @RequestMapping("/skipModifyJudge")
    public String skipModifyJudge() {
        return "modifyJudge";
    }

    /**
     * 查询一条记录
     * @param jid 传入的信息是一个 JudgeQuestion 类对象
     * @return 查询到返回 1
     */
    @RequestMapping("/findById")
    @ResponseBody
    public JsonResult findById(Integer jid) {
        JudgeQuestion judge = judgeService.findById(jid);
        return new JsonResult(1, judge);
    }

    /**
     * 删除一条判断题
     * @param jid 传入的是JudgeQuestion的Id
     * @return 删除成功返回 1
     */
    @RequestMapping("/deleteJudge")
    @ResponseBody
    public JsonResult deleteJudge(Integer jid) {
        judgeService.deleteJudge(jid);
        return new JsonResult(1, null);
    }

    /**
     * 修改一条判断题信息
     * @param judgeQuestion 传入的参数是一个 JudgeQuestion 类对象
     * @return 修改成功返回 1
     */
    @RequestMapping("/modifyJudge")
    @ResponseBody
    public JsonResult modifyJudge(JudgeQuestion judgeQuestion) {
        judgeService.modifyJudge(judgeQuestion);
        return new JsonResult(1, null);
    }

    /**
     * 跳转到查看一道判断题
     * @return 返回到 lookAtAJudge
     */
    @RequestMapping("/skipLookAtAJudge")
    public String skipLookAtAJudge() {
        return "lookAtAJudge";
    }
}
