package com.qfedu.examsys.service;

import com.qfedu.examsys.entity.ShortQuestion;

import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Name ShortService
 * @Author Yama
 * @Date 2019/9/2 9:22
 * @Version V1.0
 */
public interface ShortService {

    /**
     * 批量导入简答题
     * @param shortTitle 传入的对象是一个 ShortQuestion 的集合
     */
    public void addShortTitle(List<ShortQuestion> shortTitle);

    /**
     * 查询所有判断题信息
     * @param subjectName 传入的参数是一个学科名称，模糊查询使用
     * @param limit 分页
     * @param page
     * @return 返回查询到的信息
     */
    public Map<String, Object> findAll(String subjectName, Integer limit, Integer page);

    /**
     * 查询一条简答题的信息
     * @param sid 传入的参数是一个简答题的 Id
     * @return 返回查询到的记录
     */
    public ShortQuestion findById(Integer sid);

    /**
     * 删除一条简答题
     * @param sid 传入的参数是简答题 Id
     */
    public void deleteShort(Integer sid);

    /**
     * 修改一条简答题信息
     * @param shortQuestion 传入的参数是一个简答题信息
     */
    public void modifyShort(ShortQuestion shortQuestion);
}
