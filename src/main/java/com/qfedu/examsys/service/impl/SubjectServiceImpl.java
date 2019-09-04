package com.qfedu.examsys.service.impl;

import com.qfedu.examsys.dao.SubjectDao;
import com.qfedu.examsys.entity.Subject;
import com.qfedu.examsys.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description TODO
 * @Name SubjectServiceImpl
 * @Author Yama
 * @Date 2019/8/31 14:41
 * @Version V1.0
 */
@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired(required = false)
    private SubjectDao subjectDao;

    @Override
    public List<Subject> findAll() {

        return subjectDao.findAll();
    }

    @Override
    public Subject findBySubjectName(String name) {
        Subject subject = subjectDao.findBySubjectName(name);
        return subject;
    }
}
