package com.qfedu.examsys.dao;

import com.qfedu.examsys.vo.VApply;
import com.qfedu.examsys.vo.VScore;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface ForwardDao {

    public List<VApply> findApplyByName(@Param("name") String name, @Param("currentTime") Date currentTime);

    public List<VScore> findScoreByName(@Param("subjectId") Integer subjectId, @Param("examStart")Date examStart, @Param("examEnd")Date examEnd, @Param("name")String name);

    public Integer aidIsEmpty(Integer aid);
}
