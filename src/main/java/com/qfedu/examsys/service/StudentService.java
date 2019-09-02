package com.qfedu.examsys.service;

import com.qfedu.examsys.entity.Student;

public interface StudentService {

    public Student login(String name, String password);
}
