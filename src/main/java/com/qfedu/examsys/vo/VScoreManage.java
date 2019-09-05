package com.qfedu.examsys.vo;

import lombok.Data;

import java.util.Date;

/**
 * @ClassName VScoreManage
 * @Description TODO
 * @Author wangzhendong
 * @Date 2019/9/2
 */
@Data
public class VScoreManage {
    private Integer sid;
    private Integer studentId;
    private VApplyMessage vApplyMessage;
    private String score;
    private String studentName;
    private String subjectName;
    private Date applyStart;
    private Date applyEnd;
}
