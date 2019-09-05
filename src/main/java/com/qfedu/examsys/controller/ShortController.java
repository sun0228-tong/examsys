package com.qfedu.examsys.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qfedu.examsys.common.JsonResult;
import com.qfedu.examsys.entity.ShortQuestion;
import com.qfedu.examsys.service.ShortService;
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
 * @Name ShortController
 * @Author Yama
 * @Date 2019/9/2 9:23
 * @Version V1.0
 */
@Controller
@RequestMapping("/short")
public class ShortController {
    @Autowired
    private ShortService shortService;

    @RequestMapping("/skipShort")
    public String skipShort() {
        return "addShort";
    }

    /**
     * 导入简答题
     * @param upShort 传入的对象是 EXCEL文件
     * @return
     */
    @RequestMapping("/importShort")
    @ResponseBody
    public JsonResult importShort(@RequestParam("file") MultipartFile upShort) {
        try {
            // 获取对象输入流
            InputStream inputStream = upShort.getInputStream();
            // 获取上传对象文件名
            String filename = upShort.getOriginalFilename();
            // 获取数据的行
            List<Map<String, Object>> list = ExcelUtils.readExcel(filename, inputStream);

            ObjectMapper objectMapper = new ObjectMapper();

            String jsonStr = objectMapper.writeValueAsString(list);

            List<ShortQuestion> list1 = objectMapper.readValue(jsonStr, new TypeReference<List<ShortQuestion>>() {});

            shortService.addShortTitle(list1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new JsonResult(1, null);
    }

    /**
     * 跳转到查询所有页面
     * @return 返回到 listShort 页面
     */
    @RequestMapping("/skipListShort")
    public String skipListShort() {
        return "listShort";
    }

    /**
     * 查询所有判断题信息
     * @param subjectName 传入的参数是一个科目名称，模糊查询使用
     * @param page 分页使用
     * @param limit
     * @return 返回查询到的信息
     */
    @RequestMapping("/findAll")
    @ResponseBody
    public Map<String, Object> findAll(String subjectName,
                              Integer page,
                              Integer limit) {
        Map<String, Object> map = shortService.findAll(subjectName, page, limit);
        return map;
    }

    /**
     * 跳转到修改简答题信息的页面
     * @return 返回到 modifyShort 页面
     */
    @RequestMapping("/skipModifyShort")
    public String skipModifyShort() {
        return "modifyShort";
    }

    /**
     * 查询一条简答题
     * @param sid 传入的参数是一个 ShortQuestion 的id
     * @return 查询成功返回 1
     */
    @RequestMapping("/findById")
    @ResponseBody
    public JsonResult findById(Integer sid) {
        ShortQuestion shortQuestion = shortService.findById(sid);
        return new JsonResult(1, shortQuestion);
    }

    /**
     * 删除一条简答题信息
     * @param sid 传入的参数是简答题 Id
     * @return 删除成功返回 1
     */
    @RequestMapping("/deleteShort")
    @ResponseBody
    public JsonResult deleteShort(Integer sid) {
        shortService.deleteShort(sid);
        return new JsonResult(1, null);
    }

    /**
     * 修改一条简答题信息
     * @param shortQuestion 传入的对象是一个 ShortQuestion 类对象
     * @return 修改成功返回 1
     */
    @RequestMapping("/modifyShort")
    @ResponseBody
    public JsonResult modifyShort(ShortQuestion shortQuestion) {
        shortService.modifyShort(shortQuestion);
        return new JsonResult(1, null);
    }

    /**
     * 查看一道简答题信息
     * @return 返回到 lookAtAShort 页面
     */
    @RequestMapping("/skipLookAtAShort")
    public String skipLookAtAShort()  {
        return "lookAtAShort";
    }
}
