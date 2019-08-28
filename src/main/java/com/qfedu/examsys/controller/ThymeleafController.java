package com.qfedu.examsys.controller;

import com.qfedu.examsys.common.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Controller
public class ThymeleafController {

    // 注入模板引擎的对象
    @Autowired
    @Qualifier("myTemplateEngine")
    private TemplateEngine templateEngine;

//    @Autowired
//    private SeckillService seckillService;

    @RequestMapping("/createHtml")
    @ResponseBody
    public JsonResult createHtml(Integer sid){
        // 从数据库中获取商品信息
        //SeckillGoods seckillGoods = seckillService.findGoodsInfoById(sid);
        // Thymeleaf的上下文对象
        Context context = new Context();
        // 将秒杀商品信息存到Context对象中
        //context.setVariable("seckillGoods", seckillGoods);

        // 获取web程序运行时，文件所在的物理路径
        String path = ClassUtils.getDefaultClassLoader().getResource("").getPath();
        System.out.println(path);
        String filePath = path + "/static/" + "seckill_Detail" + sid + ".html";

        FileWriter writer = null;
        File file = new File(filePath);
        if(file.exists()){
            // 删除
            file.delete();
        }

        try {
            writer = new FileWriter(filePath);
        } catch (Exception e){

        }

        try {
            // 生成静态页面
            // 第一个参数，模板名称
            // 第二个参数，模板用到的上下文对象
            // 第三个参数，生成静态页面文件的IO流对象
            templateEngine.process("seckill_Detail", context, writer);

            // 更新数据库
            //seckillService.updateSeckillUrlById(sid, "seckill_Detail" + sid + ".html");

        } catch (Exception e) {

        } finally {
            if(writer != null){
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return new JsonResult(1, null);
    }
}
