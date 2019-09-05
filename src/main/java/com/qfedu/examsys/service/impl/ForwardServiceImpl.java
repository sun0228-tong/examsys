package com.qfedu.examsys.service.impl;

import com.github.pagehelper.PageHelper;
import com.qfedu.examsys.dao.ForwardDao;
import com.qfedu.examsys.service.ForwardService;
import com.qfedu.examsys.vo.VApply;
import com.qfedu.examsys.vo.VScore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ForwardServiceImpl implements ForwardService {

    @Autowired(required = false)
    private ForwardDao forwardDao;

    @Override
    public List<VApply> findApplyInfoByName(String name, Date currentTime, Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        List<VApply> list = forwardDao.findApplyByName(name,currentTime);
        return list;
    }

    @Override
    public List<VScore> findScoreInfoByName(Integer subjectId, Date examStart, Date examEnd, String name, Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        List<VScore> list = forwardDao.findScoreByName(subjectId,examStart,examEnd,name);
        return list;
    }

    @Override
    public Integer aidIsEmpty(Integer aid) {
        return forwardDao.aidIsEmpty(aid);
    }
}
