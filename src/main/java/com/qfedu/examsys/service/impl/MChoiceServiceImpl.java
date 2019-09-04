package com.qfedu.examsys.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qfedu.examsys.dao.MChoiceDao;
import com.qfedu.examsys.entity.MChoiceQuestion;
import com.qfedu.examsys.service.MChoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Name MChoiceServiceImpl
 * @Author Yama
 * @Date 2019/9/1 13:57
 * @Version V1.0
 */
@Service
public class MChoiceServiceImpl implements MChoiceService {
    @Autowired(required = false)
    private MChoiceDao mChoiceDao;
    @Override
    public void addMChoiceTitle(List<MChoiceQuestion> mChoiceTitle) {
        mChoiceDao.addMChoiceTitle(mChoiceTitle);
    }

    @Override
    public Map<String, Object> findAll(String subjectName, Integer page, Integer limit) {
        // 设置页码和每页显示的记录数，该语句后，紧跟数据库查询相关的语句
        PageHelper.startPage(page, limit);
        List<MChoiceQuestion> list = mChoiceDao.findAll(subjectName);
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
    public MChoiceQuestion findById(Integer mid) {
        return mChoiceDao.findById(mid);
    }

    @Override
    public void deleteMChoice(Integer mid) {
        mChoiceDao.deleteMChoice(mid);
    }

    @Override
    public void modifyMChoice(MChoiceQuestion mChoiceTitle) {
        mChoiceDao.updateMChoice(mChoiceTitle);
    }

}
