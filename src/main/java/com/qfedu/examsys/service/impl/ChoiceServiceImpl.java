package com.qfedu.examsys.service.impl;

import com.qfedu.examsys.dao.ChoiceDao;
import com.qfedu.examsys.entity.ChoiceQuestion;
import com.qfedu.examsys.service.ChoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
