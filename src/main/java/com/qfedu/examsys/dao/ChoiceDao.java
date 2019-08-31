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

    /**
     * 查询所有选择题，采用layui中的分页查询
     * @param subjectId
     * @param page
     * @param limit
     * @return 返回的是一个 ChoiceQuestion 的集合
     * @param subjectId
     */
    public List<ChoiceQuestion> findByChoiceAll(@Param("subjectId") Integer subjectId,
                                                Integer page,
                                                Integer limit);

    /**
     * 查询一条信息
     * @param cid 传入的参数是题目序号
     * @return 查询到后返回一条记录
     */
    public ChoiceQuestion findById(Integer cid);

    /**
     * 删除一条选择题,因信息不太重要，采用物理删除
     * @param cid 传入的参数是选择题的id
     */
    public void deleteChoice(Integer cid);

    /**
     * 修改试题信息
     * @param choiceQuestion 传入的参数是 choiceQuestion 类对象
     */
    public void updateChoice(ChoiceQuestion choiceQuestion);
}
