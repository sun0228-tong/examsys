package com.qfedu.examsys.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName BGSubjectScore
 * @Description 后台学科成绩图使用
 * @Author GK
 * @Date 2019/9/3   16:37
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BGSubjectScore {

    private String subjectName;
    private Integer score;
}