package com.qfedu.examsys.service;

import com.qfedu.examsys.entity.Subject;

import java.util.List;

/**
 * @Description TODO
 * @interfaceName SubjectService
 * @Author Yama
 * @Date 2019/8/31 14:41
 * @Version V1.0
 */
public interface SubjectService {
    /**
     * 查询所有学科信息
     * @return 返回查询到的信息
     */
    public List<Subject> findAll();

    public Subject findBySubjectName(String name);
}
