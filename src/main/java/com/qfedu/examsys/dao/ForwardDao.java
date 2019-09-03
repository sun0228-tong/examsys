package com.qfedu.examsys.dao;

import com.qfedu.examsys.vo.VApply;
import com.qfedu.examsys.vo.VScore;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ForwardDao {

    public List<VApply> findApplyByName(String name);

    public List<VScore> findScoreByName(String name);
}
