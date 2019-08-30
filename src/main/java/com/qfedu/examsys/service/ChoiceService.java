package com.qfedu.examsys.service;

import com.qfedu.examsys.entity.ChoiceQuestion;

import java.util.List;
import java.util.Map;

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

    /**
     * 查询所有选择题
     * @param page 页码
     * @param limit
     * @return
     */
    public Map<String, Object> findByChoiceAll(Integer page, Integer limit);
}
