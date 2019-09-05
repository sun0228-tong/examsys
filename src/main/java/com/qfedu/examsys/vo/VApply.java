package com.qfedu.examsys.vo;

import lombok.Data;

import java.util.Date;

@Data
public class VApply {
    private Integer aid;
    private String subjectName;
    private String studentName;
    private Date examStart;
    private Date examEnd;
    private Integer examManageId;
    private Integer examTime;
}
