package com.qfedu.examsys.examination;

import lombok.Data;

import java.util.List;

@Data
public class Judges {
    private String title;
    private Object infos;
    private List<Judge> values;

    public Judges() {
        setTitle("判断题");
    }
}
