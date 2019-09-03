package com.qfedu.examsys.vo;

import lombok.Data;

@Data
public class VScore {
    private Integer sid;
    private String studentName;
    private String subjectName;
    private Integer eid;
    private Integer score;
}
