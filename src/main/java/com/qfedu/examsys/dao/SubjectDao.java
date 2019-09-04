package com.qfedu.examsys.dao;

import com.qfedu.examsys.entity.Subject;

import java.util.List;

/**
 * @Description TODO
 * @interfaceName SubjectDao
 * @Author Yama
 * @Date 2019/8/31 14:40
 * @Version V1.0
 */
public interface SubjectDao {
    /**
     * 查询所有学科信息
     * @return 返回的是查询到的信息
     */
    public List<Subject> findAll();

    public Subject findBySubjectName(String name);
}
