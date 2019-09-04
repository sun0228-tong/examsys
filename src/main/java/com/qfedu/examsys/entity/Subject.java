package com.qfedu.examsys.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @Description TODO
 * @Name Subject
 * @Author Yama
 * @Date 2019/8/31 14:26
 * @Version V1.0
 */
@Data
public class Subject {
    private Integer sid;
    private String subjectName;
}
