package com.qfedu.examsys.service.impl;

import com.github.pagehelper.PageHelper;
import com.qfedu.examsys.dao.AnotherDao;
import com.qfedu.examsys.service.AnotherService;
import com.qfedu.examsys.vo.Another;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AnotherServiceImpl implements AnotherService {

    @Autowired(required = false)
    private AnotherDao anotherDao;

    @Override
    public List<Another> findAllSM(Integer page, Integer limit, Integer subjectId) {
        PageHelper.startPage(page,limit);
        List<Another> list = anotherDao.findAllSM(subjectId);
        return list;
    }

    @Override
    public String findOneAM(Integer id) {
        String answer = anotherDao.findOneAM(id);
        return answer;
    }
}
