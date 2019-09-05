package com.qfedu.examsys.dao;

import com.qfedu.examsys.entity.BGExamScore;
import com.qfedu.examsys.entity.BGSubjectScore;
import com.qfedu.examsys.entity.FMExamScore;

import java.util.List;

/**
 * @ClassName EChartsDao
 * @Description 折线图 Dao 层
 * @Author GK
 * @Date 2019/9/3   17:14
 */
public interface EChartsDao {

    // 后台展示
    public List<BGExamScore> findExamAndScore();

    // 后台展示
    public List<BGSubjectScore> findSubjectNameAndScore();

    // 前台展示
    public List<FMExamScore> findStudentNameAndScore(Integer eid);

    // 前台展示用eid
    public List<FMExamScore> findStudentNameAndScoreById();
}