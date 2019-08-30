package com.qfedu.examsys.dao;

import com.qfedu.examsys.entity.ChoiceQuestion;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @Description TODO
 * @Name ChoiceDao
 * @Author Yama
 * @Date 2019/8/29 20:49
 * @Version V1.0
 */
public interface ChoiceDao {

    /**
     * 批量插入选择题
     * @param choiceTitle 传入的对象是一个 ChoiceQuestion 类对象
     */
    public void addChoiceTitle(@Param("choiceTitle") List<ChoiceQuestion> choiceTitle);
}
