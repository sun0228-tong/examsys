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

    /**
     * 查询一科
     * @param sid 传入的参数是学科 Id
     * @return 返回查询到的对象
     */
    public Subject findById(Integer sid);

    /**
     * 添加一科学科信息
     * @param subject 传入的参数是一个 Subject 类对象
     */
    public void addSubject(Subject subject);

    /**
     * 修改一科学科信息
     * @param subject 传入的参数是一个 Subject 类对象
     */
    public void modifySubject(Subject subject);
}
