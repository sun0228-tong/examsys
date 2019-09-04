package com.qfedu.examsys.dao;

import com.qfedu.examsys.entity.MChoiceQuestion;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @Description TODO
 * @interfaceName
 * @Author Yama
 * @Date 2019/9/1  13:56
 * @Version V1.0
 */
public interface MChoiceDao {

    /**
     * 批量插入多选题
     * @param mChoiceTitle
     */
    public void addMChoiceTitle(@Param("mChoiceTitle") List<MChoiceQuestion> mChoiceTitle);

    /**
     * 模糊查询，查询所有多选题
     * @param subjectName 传入的参数是一个 科目名称
     * @return 返回的是一个 MChoiceQuestion 类对象
     */
    public List<MChoiceQuestion> findAll(@Param("subjectName") String subjectName);

    /**
     * 查询一条数据
     * @param mid 传入的参数是一个 mChoiceQuestion 类对象
     * @return 返回值是查询到的数据
     */
    public MChoiceQuestion findById(Integer mid);

    /**
     * 删除一条 MChoice_question 信息
     * @param mid 传入的参数是一个ID
     */
    public void deleteMChoice(Integer mid);

    /**
     * 修改单选题信息
     * @param mChoiceTitle 传入的对象是一个 mChoiceQuestion 类对象
     */
    public void updateMChoice(MChoiceQuestion mChoiceTitle);


}
