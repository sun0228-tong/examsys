package com.qfedu.examsys.entity;

import lombok.Data;

/**
 * @Description TODO
 * @Name MChoiceQuestion 多选题实体类
 * @Author Yama
 * @Date 2019/8/28 22:58
 * @Version V1.0
 */
@Data
public class MChoiceQuestion {
    private Integer mid;
    private Integer score;
    private String question;
    private String choiceA;
    private String choiceB;
    private String choiceC;
    private String choiceD;
    private String rightAnswer;
    private Integer subjectId;

    // 页面显示需要学科 Name
    private String subjectName;
}
