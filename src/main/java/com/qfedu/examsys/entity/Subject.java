package com.qfedu.examsys.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @Description TODO
 * @Name Subject
 * @Author Yama
 * @Date 2019/8/31 14:26
 * @Version V1.0
 */
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Subject {
    private Integer sid;
    private String subjectName;
}
