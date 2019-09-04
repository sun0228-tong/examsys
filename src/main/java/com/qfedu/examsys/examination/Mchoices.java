package com.qfedu.examsys.examination;

import lombok.Data;

import java.util.List;

@Data
public class Mchoices {
    private String title;
    private Object infos;
    private List<Mchoice> values;

    public Mchoices() {
        setTitle("多项选择题");
    }
}
