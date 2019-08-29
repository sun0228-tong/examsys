package com.qfedu.examsys.entity;

import lombok.Data;

/**
 * @Description TODO
 * @Name MchoiceQuestion 多选题实体类
 * @Author Yama
 * @Date 2019/8/28 22:58
 * @Version V1.0
 */
@Data
public class MchoiceQuestion {
    private Integer mid;
    private Integer score;
    private String question;
    private String choiceA;
    private String choiceB;
    private String choiceC;
    private String choiceD;
    private String rightAnswer;
    private Integer subjectId;
}
