package com.qfedu.examsys.service;

import com.qfedu.examsys.vo.Another;

import java.util.List;

public interface AnotherService {

    public List<Another> findAllSM(Integer page, Integer limit, Integer subjectId);

    public String findOneAM(Integer id);

}
