package com.qfedu.examsys.service;

import com.qfedu.examsys.entity.Student;

import java.util.List;

public interface StudentService {

    public Student login(String name, String password);

    public void addStus(Student student);

    public void deleteStusById(Integer sid);

    public void updateStus(Student student);

    public Student findStusById(Integer sid);

    public List<Student> findAllStus();

    public List<String> findAllEmail();

    public Student findByStudentName(String name);
}
