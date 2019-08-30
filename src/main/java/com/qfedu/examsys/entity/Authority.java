package com.qfedu.examsys.entity;

import lombok.Data;

@Data
public class Authority {
    private Integer pid;
    private String pmenu;
    private String cmenu;
    private Integer cid;
    private String url;
}
