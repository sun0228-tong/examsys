package com.qfedu.examsys.service.impl;

import com.qfedu.examsys.dao.StudentDao;
import com.qfedu.examsys.entity.Student;
import com.qfedu.examsys.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired(required = false)
    private StudentDao studentDao;

    @Override
    public Student login(String name, String password) {
        Student student = studentDao.findByStudentNameAndPassword(name, password);
        return student;
    }

    @Override
    public void addStus(Student student) {
        studentDao.add(student);
    }

    @Override
    public void deleteStusById(Integer sid) {
        studentDao.deleteById(sid);
    }

    @Override
    public void updateStus(Student student) {
        studentDao.update(student);
    }

    @Override
    public Student findStusById(Integer sid) {
        return studentDao.findById(sid);
    }

    @Override
    public List<Student> findAllStus() {
        return studentDao.findAll();
    }

    @Override
    public List<String> findAllEmail() {
        return studentDao.findAllEmail();
    }

    @Override
    public Student findByStudentName(String name) {
        return studentDao.findByStudentName(name);
    }
}
