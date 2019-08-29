package com.qfedu.examsys.entity;

import lombok.Data;

/**
 * @Description TODO
 * @Name JudgeQuestion 判断题实体
 * @Author Yama
 * @Date 2019/8/28 22:55
 * @Version V1.0
 */
@Data
public class JudgeQuestion {
    private Integer jid;
    private Integer score;
    private String question;
    private Integer choiceA;
    private Integer choiceB;
    private Integer rightAnswer;
    private Integer subjectId;
}
