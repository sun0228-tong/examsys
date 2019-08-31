package com.qfedu.examsys.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qfedu.examsys.dao.ChoiceDao;
import com.qfedu.examsys.entity.ChoiceQuestion;
import com.qfedu.examsys.service.ChoiceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Name ChoiceServiceImpl
 * @Author Yama
 * @Date 2019/8/29 20:50
 * @Version V1.0
 */
@Service
public class ChoiceServiceImpl implements ChoiceService {

    @Autowired(required = false)
    private ChoiceDao choiceDao;

    @Override
    public void addChoiceTitle(List<ChoiceQuestion> choiceTitle) {
        choiceDao.addChoiceTitle(choiceTitle);
    }

    @Override
    public Map<String, Object> findByChoiceAll(Integer subjectId, Integer page, Integer limit) {
        // 设置页码和每页显示的记录数，该语句后面，紧跟着数据库查询相关的语句
        PageHelper.startPage(page, limit);
        List<ChoiceQuestion> list = choiceDao.findByChoiceAll(subjectId, page, limit);
        Map<String, Object> map = new HashMap<>();
        long total = ((Page) list).getTotal();
        map.put("code", 0);
        map.put("msg", "");
        // 表中总记录数
        map.put("count", total);
        // 获取到的分页数据
        map.put("data", list);
        return map;
    }

    @Override
    public ChoiceQuestion findById(Integer cid) {
        return choiceDao.findById(cid);
    }

    @Override
    public void deleteChoice(Integer cid) {
        choiceDao.deleteChoice(cid);
    }

    @Override
    public void updateChoice(ChoiceQuestion choiceQuestion) {
        choiceDao.updateChoice(choiceQuestion);
    }
}
