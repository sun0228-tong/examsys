package com.qfedu.examsys.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName FMExamScore
 * @Description 前台展示各考场的分数
 * @Author GK
 * @Date 2019/9/4   16:53
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FMExamScore {

    //横坐标表示学生名字，纵坐标表示学生分数
    private String studentName;
    private Integer score;
    private Integer eid;
}