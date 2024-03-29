package com.qfedu.examsys.dao;

import com.qfedu.examsys.entity.ApplyMessage;
import com.qfedu.examsys.entity.ExamManage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName ExamManageDao
 * @Description 考试信息管理 Dao 层ExamManageMapper
 * @Author GK
 * @Date 2019/8/30   15:05
 */
public interface ExamManageDao {

    public void add(ExamManage examManage);

    public void deleteById(Integer eid);

    public void update(ExamManage examManage);

    public ExamManage findById(Integer eid);

    public List<ExamManage> findAllByPage();

    public ApplyMessage findByExamManageId(@Param("examManageId") Integer examManageId, @Param("studentId") Integer studentId);
}