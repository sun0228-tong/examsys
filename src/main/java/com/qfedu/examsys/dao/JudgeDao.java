package com.qfedu.examsys.dao;

import com.qfedu.examsys.entity.JudgeQuestion;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @Description TODO
 * @interfaceName JudgeDao
 * @Author Yama
 * @Date 2019/9/1 14:46
 * @Version V1.0
 */
public interface JudgeDao {
    /**
     * 批量导入判断题
     * @param judgeTitle 传入的参数是一个 JudgeQuestion 类对象
     */
    public void addJudgeTitle(@Param("judgeTitle") List<JudgeQuestion> judgeTitle);

    /**
     * 查询所有判断题，使用模糊查询
     * @param subjectName 传入的参数是一个科目名称
     * @return 返回的是查询到的信息
     */
    public List<JudgeQuestion> findAll(@Param("subjectName") String subjectName);

    /**
     * 查询一个用户的信息
     * @param mid 传入的参数是一个 JudgeQuestion id
     * @return 查询到后返回查询到的记录
     */
    public JudgeQuestion findById(Integer mid);

    /**
     * 删除一条判断题
     * @param jid 传入的参数是一个判断题的 ID
     */
    public void deleteJudge(Integer jid);

    /**
     * 修改一条判断题信息
     * @param judgeQuestion 传入的对象是一个 JudgeQuestion 类对象
     */
    public void modifyJudge(JudgeQuestion judgeQuestion);
}
