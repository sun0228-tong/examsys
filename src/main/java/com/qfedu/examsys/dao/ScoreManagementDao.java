package com.qfedu.examsys.dao;

import com.qfedu.examsys.entity.Subject;
import com.qfedu.examsys.vo.VScoreManage;

import java.util.HashMap;
import java.util.List;

public interface ScoreManagementDao {
    List<VScoreManage> findAllScoreManage(HashMap<Object,Object> map);

    VScoreManage findByIdScoreManage(Integer sid);

    List<Subject> findAllSubject();

    int updateScoreManage(VScoreManage vScoreManage);
}
