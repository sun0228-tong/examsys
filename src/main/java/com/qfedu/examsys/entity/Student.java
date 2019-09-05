package com.qfedu.examsys.entity;

import lombok.Data;

@Data
public class Student {
    private Integer sid;
    private String studentName;
    private String email;
    private String password;
    private String sex;
    private String phone;
}
