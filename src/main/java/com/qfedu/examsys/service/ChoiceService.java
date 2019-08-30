package com.qfedu.examsys.service;

import com.qfedu.examsys.entity.ChoiceQuestion;

import java.util.List;

/**
 * @Description TODO
 * @interfaceName ChoiceService
 * @Author Yama
 * @Date 2019/8/29 20:49
 * @Version V1.0
 */
public interface ChoiceService {
    /**
     * 批量插入选择题
     * @param choiceTitle 传入的对象是一个 ChoiceQuestion的list集合
     */
    public void addChoiceTitle(List<ChoiceQuestion> choiceTitle);
}
