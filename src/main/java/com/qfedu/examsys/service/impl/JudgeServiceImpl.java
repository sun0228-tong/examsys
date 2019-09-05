package com.qfedu.examsys.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qfedu.examsys.dao.JudgeDao;
import com.qfedu.examsys.entity.JudgeQuestion;
import com.qfedu.examsys.service.JudgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Name JudgeServiceImpl
 * @Author Yama
 * @Date 2019/9/1 14:47
 * @Version V1.0
 */
@Service
public class JudgeServiceImpl implements JudgeService {

    @Autowired(required = false)
    private JudgeDao judgeDao;

    @Override
    public void addJudgeTitle(List<JudgeQuestion> judgeTitle) {
        judgeDao.addJudgeTitle(judgeTitle);
    }

    @Override
    public Map<String, Object> findAll(String subjectName, Integer page, Integer limit) {
        // 设置页码和每页显示的记录数，该语句后，紧跟数据库查询相关语句
        PageHelper.startPage(page, limit);
        List<JudgeQuestion> list = judgeDao.findAll(subjectName);
        Map<String, Object> map = new HashMap<>();

        long total = ((Page) list).getTotal();
        map.put("code", 0);

        map.put("msg", "");
        // EXCEL中总记录数
        map.put("count", total);
        // 获取到的分页数据
        map.put("data", list);
        return map;
    }

    @Override
    public JudgeQuestion findById(Integer jid) {
        return judgeDao.findById(jid);
    }

    @Override
    public void deleteJudge(Integer jid) {
        judgeDao.deleteJudge(jid);
    }

    @Override
    public void modifyJudge(JudgeQuestion judgeQuestion) {
        judgeDao.modifyJudge(judgeQuestion);
    }
}
