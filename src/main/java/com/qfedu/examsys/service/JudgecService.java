package com.qfedu.examsys.service;

import com.qfedu.examsys.entity.ShortManage;

import java.util.List;

public interface JudgecService {
    public ShortManage toUpdatePageFind(Integer sid);

    public List<Integer> sidArray(Integer sid, Integer subjectId);
}
