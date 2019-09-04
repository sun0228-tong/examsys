package com.qfedu.examsys.dao;

import com.qfedu.examsys.vo.VScoreManage;

import java.util.List;

public interface ScoreManagementDao {
    List<VScoreManage> findAllScoreManage(Integer sid);

    public void delScoreById(Integer sid);
}
