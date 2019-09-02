package com.qfedu.examsys.service.impl;

import com.qfedu.examsys.dao.StudentDao;
import com.qfedu.examsys.entity.Student;
import com.qfedu.examsys.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired(required = false)
    private StudentDao studentDao;

    @Override
    public Student login(String name, String password) {
        Student student = studentDao.findByStudentNameAndPassword(name, password);
        return student;
    }
}
