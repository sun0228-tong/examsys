package com.qfedu.examsys.service;

import com.qfedu.examsys.vo.VApply;
import com.qfedu.examsys.vo.VScore;

import java.util.List;

public interface ForwardService {

    public List<VApply> findApplyInfoByName(String name, Integer page, Integer limit);

    public List<VScore> findScoreInfoByName(String name, Integer page, Integer limit);
}
