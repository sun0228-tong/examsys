package com.qfedu.examsys.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName ExamManage
 * @Description 考试信息管理实体类
 * @Author GK
 * @Date 2019/8/30   14:53
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamManage {
    private Integer eid;
    private Integer subjectId;
    private Date applyStart;
    private Date applyEnd;
    private Date examStart;
    private Date examEnd;
    private String examTime;
    private String subjectName;
}