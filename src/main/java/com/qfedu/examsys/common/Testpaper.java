package com.qfedu.examsys.common;

import lombok.Data;

import java.util.List;

@Data
public class Testpaper {
    private String title;
    private List exam;

    public Testpaper() {
        this(null);
    }

    public Testpaper(List exam) {
        this.title = "试卷";
        this.exam = exam;
    }
}
