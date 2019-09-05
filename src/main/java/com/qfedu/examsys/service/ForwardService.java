package com.qfedu.examsys.service;

import com.qfedu.examsys.vo.VApply;
import com.qfedu.examsys.vo.VScore;

import java.util.Date;
import java.util.List;

public interface ForwardService {

    public List<VApply> findApplyInfoByName(String name,Date currentTime, Integer page, Integer limit);

    public List<VScore> findScoreInfoByName(Integer subjectId, Date examStart, Date examEnd, String name, Integer page, Integer limit);

    public Integer aidIsEmpty(Integer aid);
}
