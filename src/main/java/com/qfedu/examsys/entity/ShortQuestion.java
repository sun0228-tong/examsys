package com.qfedu.examsys.entity;

import lombok.Data;

/**
 * @Description TODO
 * @Name ShortQuestion 简答题
 * @Author Yama
 * @Date 2019/8/28 23:05
 * @Version V1.0
 */
@Data
public class ShortQuestion {
    private Integer sid;
    private Integer score;
    private String question;
    private Integer subjectId;
    private String rightAnswer;
    // 页面显示需要学科 Name
    private String subjectName;
}
