package com.qfedu.examsys.dao;

import com.qfedu.examsys.vo.Another;

import java.util.List;

public interface AnotherDao {
    public List<Another> findAllSM(Integer subjectId);

    public String findOneAM(Integer id);
}
