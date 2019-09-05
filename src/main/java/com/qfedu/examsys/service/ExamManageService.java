package com.qfedu.examsys.service;

import com.qfedu.examsys.entity.ApplyMessage;
import com.qfedu.examsys.entity.ExamManage;

import java.util.List;

/**
 * @ClassName ExamManageService
 * @Description 考试信息服务层
 * @Author GK
 * @Date 2019/8/30   15:49
 */
public interface ExamManageService {

    public void addEms(ExamManage examManage);

    public void deleteEmsById(Integer eid);

    public void updateEms(ExamManage examManage);

    public ExamManage findEmsById(Integer eid);

    public List<ExamManage> findAllEmsByPage(Integer page, Integer limit);

    public ApplyMessage findByExamManageId(Integer examManageId, Integer studentId);
}