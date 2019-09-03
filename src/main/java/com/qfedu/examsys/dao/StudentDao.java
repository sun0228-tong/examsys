package com.qfedu.examsys.dao;

import com.qfedu.examsys.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao {

    public Student findByStudentNameAndPassword(@Param("name") String name, @Param("password") String password);


}
