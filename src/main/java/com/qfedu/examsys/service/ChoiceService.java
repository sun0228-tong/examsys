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
    public Map<String, Object> findByChoiceAll(String subjectName,
                                               Integer page,
                                               Integer limit);

    /**
     * 查询一条记录
     * @param cid 传入的参数是题目id
     * @return 查询到返回一条记录
     */
    public ChoiceQuestion findById(Integer cid);

    /**
     * 删除一条选择题
     * @param cid 传入的参数是题目ID
     */
    public void deleteChoice(Integer cid);

    /**
     * 修改一条选择题信息
     * @param choiceQuestion 传入的对象是一个 ChoiceQuestion 类对象
     */
    public void updateChoice(ChoiceQuestion choiceQuestion);

}
