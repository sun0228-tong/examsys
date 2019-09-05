package com.qfedu.examsys.service;

import com.qfedu.examsys.entity.Subject;

import java.util.List;
import java.util.Map;

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

    /**
     * 查询一科信息
     * @param sid 传入的参数是一个Id
     * @return 返回查询到的一条数据
     */
    public Subject findById(Integer sid);

    /**
     * 添加一条科目信息
     * @param subject 传入的参数是一个 Subject 类对象
     */
    public void addSubject(Subject subject);

    /**
     * 修改一条科目信息
     * @param subject 传入的对象是一个 Subject 类对象
     */
    public void modifySubject(Subject subject);

    /**
     * 分页查询所有信息
     * @param page
     * @param limit
     * @return
     */
    public Map<String, Object> findBySubject(Integer page, Integer limit);

    public Subject findBySubjectName(String name);
}
