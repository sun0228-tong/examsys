package com.qfedu.examsys.entity;

import lombok.Data;

import java.util.List;

@Data
public class Examination {
    private List<ChoiceQuestion> choiceQuestions;
    private List<MChoiceQuestion> mchoiceQuestions;
    private List<JudgeQuestion> judgeQuestions;
    private List<ShortQuestion> shortQuestions;
}
