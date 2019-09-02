package com.qfedu.examsys.examination;

import lombok.Data;

import java.util.List;

@Data
public class Choices {
    private String title;
    private Object infos;
    private List<Choice> values;

    public Choices() {
        setTitle("单项选择题");
    }
}
