package com.qfedu.examsys.service;

import com.qfedu.examsys.vo.VScoreManage;

import java.util.Map;

public interface ScoreManagementService {
    Map<String, Object> findAllScoreManage(Integer page, Integer limit, String studentName, String subjectName, Integer eid);

    Map<String, Object> findByIdScoreManage(Integer sid);

    Map<String, Object> findAllSubject();

    Map<String, Object> updateScoreManage(VScoreManage vScoreManage);

    public void delScoreById(Integer id);
}
