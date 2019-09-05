package com.qfedu.examsys.service.impl;

import com.qfedu.examsys.dao.EChartsDao;
import com.qfedu.examsys.entity.BGExamScore;
import com.qfedu.examsys.entity.BGSubjectScore;
import com.qfedu.examsys.entity.FMExamScore;
import com.qfedu.examsys.service.EChartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName FExamScoreServiceImpl
 * @Description 折线图服务层实现类
 * @Author GK
 * @Date 2019/9/3   17:25
 */
@Service
public class EChartsServiceImpl implements EChartsService {

    @Autowired(required = false)
    private EChartsDao eChartsDao;

    @Override
    public List<BGExamScore> findExamAndScore() {

        List<BGExamScore> list = eChartsDao.findExamAndScore();

        return list;
    }

    @Override
    public List<BGSubjectScore> findSubjectNameAndScore() {

        List<BGSubjectScore> list = eChartsDao.findSubjectNameAndScore();

        return list;
    }

    @Override
    public List<FMExamScore> findStudentNameAndScore(Integer eid) {

        List<FMExamScore> list = eChartsDao.findStudentNameAndScore(eid);

        return list;
    }

    @Override
    public List<FMExamScore> findStudentNameAndScoreById() {

        List<FMExamScore> list = eChartsDao.findStudentNameAndScoreById();

        return list;
    }
}