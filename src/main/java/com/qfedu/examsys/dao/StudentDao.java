package com.qfedu.examsys.dao;

import com.qfedu.examsys.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName StudentDao
 * @Description 学生信息管理 Dao 层
 * @Author GK
 * @Date 2019/8/29   11:47
 */
public interface StudentDao {

    public void add(Student student);

    public void deleteById(Integer sid);

    public void update(Student student);

    public Student findById(Integer sid);

    public List<Student> findAll();

    public List<String> findAllEmail();

    public Student findByStudentName(String name);
	
	public Student findByStudentNameAndPassword(@Param("name") String name, @Param("password") String password);
}