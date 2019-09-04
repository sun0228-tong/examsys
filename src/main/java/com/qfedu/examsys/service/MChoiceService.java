package com.qfedu.examsys.service;

import com.qfedu.examsys.entity.MChoiceQuestion;

import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @interfaceName MChoiceService
 * @Author Yama
 * @Date 2019/9/1 13:57
 * @Version V1.0
 */
public interface MChoiceService {
    /**
     * 批量导入多选题
     * @param mChoiceTitle 传入的参数是一个 MChoiceQuestion 实体类
     */
    public void addMChoiceTitle(List<MChoiceQuestion> mChoiceTitle);

    /**
     * 查询所有多选题信息
     * @param subjectName 需要模糊查询，需要传入的参数是一个 学科名称
     * @param limit
     * @param page
     * @return 返回的是查询到的 MChoiceQuestion 类对象的集合
     */
    public Map<String, Object> findAll (String subjectName, Integer limit, Integer page);

    /**
     * 查询一条数据
     * @param mid 传入的参数是一个 mChoiceQuestion 类对象的ID
     * @return 返回查询到的数据
     */
    public MChoiceQuestion findById(Integer mid);

    /**
     * 删除一条 mChoice_Question 信息
     * @param mid 传入的参数是一个Id
     */
    public void deleteMChoice(Integer mid);

    /**
     * 修改多选题信息
     * @param mChoiceTitle 传入的对象是一个 MChoiceQuestion 实体类
     */
    public void modifyMChoice(MChoiceQuestion mChoiceTitle);
}
