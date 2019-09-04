package com.qfedu.examsys.service.impl;

import com.github.pagehelper.PageHelper;
import com.qfedu.examsys.dao.ApplyMessageDao;
import com.qfedu.examsys.entity.ApplyMessage;
import com.qfedu.examsys.entity.ExamManage;
import com.qfedu.examsys.service.ApplyMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName ApplyMessageServiceImpl
 * @Description 报名信息管理服务层实现类
 * @Author GK
 * @Date 2019/9/2   10:10
 */
@Service
public class ApplyMessageServiceImpl implements ApplyMessageService {

    @Autowired(required = false)
    private ApplyMessageDao applyMessageDao;


    @Override
    public void addAms(ApplyMessage applyMessage) {

        applyMessageDao.add(applyMessage);
    }

    @Override
    public void deleteAmsById(Integer aid) {

        applyMessageDao.deleteById(aid);
    }

    @Override
    public void updateAms(ApplyMessage applyMessage) {

        applyMessageDao.update(applyMessage);
    }

    @Override
    public ApplyMessage findAmsById(Integer aid) {

        return applyMessageDao.findById(aid);
    }

    @Override
    public List<ApplyMessage> findAllAms(Integer page, Integer limit) {

        PageHelper.startPage(page, limit);
        List<ApplyMessage> list = applyMessageDao.findAllByPage();

        return list;
    }
}