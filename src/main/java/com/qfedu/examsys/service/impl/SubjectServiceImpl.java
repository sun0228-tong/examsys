package com.qfedu.examsys.service.impl;

import com.qfedu.examsys.dao.SubjectDao;
import com.qfedu.examsys.entity.Subject;
import com.qfedu.examsys.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Name SubjectServiceImpl
 * @Author Yama
 * @Date 2019/8/31 14:41
 * @Version V1.0
 */
@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired(required = false)
    private SubjectDao subjectDao;

    @Override
    public List<Subject> findAll() {
        return subjectDao.findAll();
    }

    @Override
    public Subject findById(Integer sid) {
        return subjectDao.findById(sid);
    }

    @Override
    public void addSubject(Subject subject) {
        subjectDao.addSubject(subject);
    }

    @Override
    public void modifySubject(Subject subject) {
        subjectDao.modifySubject(subject);
    }

    @Override
    public Map<String, Object> findBySubject(Integer page, Integer limit) {

        // 设置页码和每页显示的记录数，该语句后，跟着数据库查询相关的语句
        PageHelper.startPage(page, limit);

        List<Subject> list = subjectDao.findAll();
        Map<String, Object> map = new HashMap<>();
        long total = ((Page) list).getTotal();
        map.put("code", 0);
        map.put("msg", "");
        // 表中总记录
        map.put("count", total);
        // 获取到的分页数据
        map.put("data", list);
        return map;
    }
}
