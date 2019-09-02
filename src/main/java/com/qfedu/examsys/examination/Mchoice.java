package com.qfedu.examsys.examination;

import lombok.Data;

import java.util.List;

@Data
public class Mchoice {
    private Integer type;
    private String questionStem;
    private List<String> options;
//    private char[] answer;
    private List<String> answer;
    private String analysis;
    private Integer score;

    public Mchoice() {
        setType(2);
    }
}
