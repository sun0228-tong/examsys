package com.qfedu.examsys.examination;

import lombok.Data;

import java.util.List;

@Data
public class Shorta {
    private Integer type;
    private String questionStem;
    private List<String> options;
    private List<String> answer;
    private String analysis;

    public Shorta() {
        setType(5);
    }
}
