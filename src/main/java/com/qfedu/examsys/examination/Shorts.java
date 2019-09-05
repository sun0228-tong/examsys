package com.qfedu.examsys.examination;

import lombok.Data;

import java.util.List;

@Data
public class Shorts {
    private String title;
    private Object infos;
    private List<Shorta> values;

    public Shorts() {
        setTitle("简答题");
    }
}
