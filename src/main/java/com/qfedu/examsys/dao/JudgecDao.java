package com.qfedu.examsys.dao;

import com.qfedu.examsys.entity.ShortManage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface JudgecDao {
    public ShortManage findManageById(Integer sid);

    public void updateChecking(@Param("sid") Integer sid, @Param("checking") Integer checking);

    public List<Integer> sidArray(@Param("sid") Integer sid, @Param("subjectId") Integer subjectId);

    public void updateHasChecking(Integer sid);

    public ShortManage shits(Integer sid);

    public ShortManage findByAid(Integer aid);
}
