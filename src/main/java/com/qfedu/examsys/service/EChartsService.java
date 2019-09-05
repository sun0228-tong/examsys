package com.qfedu.examsys.service;

import com.qfedu.examsys.entity.BGExamScore;
import com.qfedu.examsys.entity.BGSubjectScore;
import com.qfedu.examsys.entity.FMExamScore;

import java.util.List;

/**
 * @ClassName EChartsService
 * @Description 折线图服务层
 * @Author GK
 * @Date 2019/9/4   11:50
 */
public interface EChartsService {

    public List<BGExamScore> findExamAndScore();

    public List<BGSubjectScore> findSubjectNameAndScore();

    public List<FMExamScore> findStudentNameAndScore(Integer eid);

    public List<FMExamScore> findStudentNameAndScoreById();
}