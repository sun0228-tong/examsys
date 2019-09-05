package com.qfedu.examsys.dao;

import com.qfedu.examsys.entity.ChoiceQuestion;
import com.qfedu.examsys.entity.JudgeQuestion;
import com.qfedu.examsys.entity.MchoiceQuestion;
import com.qfedu.examsys.entity.ShortQuestion;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExaminationDao {
    public List<ChoiceQuestion> choiceQuestionList(@Param("subjectId")Integer subjectId,@Param("count") Integer count);

    public List<MchoiceQuestion> mchoiceQuestionList(@Param("subjectId")Integer subjectId,@Param("count") Integer count);

    public List<JudgeQuestion> judgeQuestionList(@Param("subjectId")Integer subjectId,@Param("count") Integer count);

    public List<ShortQuestion> shortQuestionList(@Param("subjectId")Integer subjectId,@Param("count") Integer count);
}
