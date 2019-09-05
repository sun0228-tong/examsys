package com.qfedu.examsys.service.impl;

import com.qfedu.examsys.dao.ScoreManageDao;
import com.qfedu.examsys.entity.ScoreManage;
import com.qfedu.examsys.service.ScoreManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreManageServiceImpl implements ScoreManageService {
    @Autowired(required = false)
    private ScoreManageDao scoreManageDao;

    @Override
    public void subm(ScoreManage scoreManage) {
        scoreManageDao.add(scoreManage);
    }
}
