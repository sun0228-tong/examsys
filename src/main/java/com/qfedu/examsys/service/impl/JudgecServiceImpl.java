package com.qfedu.examsys.service.impl;

import com.qfedu.examsys.dao.JudgecDao;
import com.qfedu.examsys.entity.ShortManage;
import com.qfedu.examsys.service.JudgecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JudgecServiceImpl implements JudgecService {

    @Autowired(required = false)
    private JudgecDao judgecDao;

    @Override
    public ShortManage toUpdatePageFind(Integer sid) {
        ShortManage shortManage = judgecDao.findManageById(sid);
        judgecDao.updateChecking(sid,1);
        return shortManage;
    }

    @Override
    public List<Integer> sidArray(Integer sid, Integer subjectId) {
        return judgecDao.sidArray(sid, subjectId);
    }
}
