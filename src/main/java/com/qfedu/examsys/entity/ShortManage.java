package com.qfedu.examsys.entity;

import lombok.Data;

@Data
public class ShortManage {
    private Integer sid;
    private Integer shortId;
    private String answer;
    private Integer otherScore;
    private Integer aid;
    private boolean hasChecked;
}
