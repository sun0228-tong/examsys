package com.qfedu.examsys.service.impl;


import com.github.pagehelper.PageHelper;
import com.qfedu.examsys.dao.ExamManageDao;
import com.qfedu.examsys.entity.ExamManage;
import com.qfedu.examsys.service.ExamManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName ExamManageServiceImpl
 * @Description TODO
 * @Author GK
 * @Date 2019/8/30   15:49
 */
@Service
public class ExamManageServiceImpl implements ExamManageService {

    @Autowired(required = false)
    private ExamManageDao examManageDao;

    @Override
    public void addEms(ExamManage examManage) {

        examManageDao.add(examManage);
    }

    @Override
    public void deleteEmsById(Integer eid) {

        examManageDao.deleteById(eid);
    }

    @Override
    public void updateEms(ExamManage examManage) {

        examManageDao.update(examManage);
    }

    @Override
    public ExamManage findEmsById(Integer eid) {

        return examManageDao.findById(eid);
    }

    @Override
    public List<ExamManage> findAllEmsByPage(Integer page, Integer limit) {

        PageHelper.startPage(page, limit);
        List<ExamManage> list = examManageDao.findAllByPage();

        return list;
    }
}