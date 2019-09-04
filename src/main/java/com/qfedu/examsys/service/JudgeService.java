package com.qfedu.examsys.service;

import com.qfedu.examsys.entity.JudgeQuestion;

import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @interfaceName JudgeService
 * @Author Yama
 * @Date 2019/9/1 14:46
 * @Version V1.0
 */
public interface JudgeService {
    /**
     * 批量导入判断题
     * @param judgeTitle 传入的对象是一个 JudgeQuestion 试题类
     */
    public void addJudgeTitle(List<JudgeQuestion> judgeTitle);

    /**
     * 查询所有判断题
     * @param subjectName 传入的参数是科目名称，用以模糊查询
     * @param limit
     * @param page
     * @return
     */
    public Map<String, Object> findAll(String subjectName, Integer limit, Integer page);

    /**
     * 查询一条记录，查询到后返回查询到的对象
     * @param jid 传入的信息是一个判断题ID
     * @return 返回查询到的一条记录
     */
    public JudgeQuestion findById(Integer jid);

    /**
     * 删除一条判断题
     * @param jid 传入的信息是一个 JudgeQuestion 的ID
     */
    public void deleteJudge(Integer jid);

    /**
     * 修改一条判断题
     * @param judgeQuestion 传入的参数是一个 JudgeQuestion 类对象
     */
    public void modifyJudge(JudgeQuestion judgeQuestion);
}
