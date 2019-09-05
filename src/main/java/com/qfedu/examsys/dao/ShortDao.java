package com.qfedu.examsys.dao;

import com.qfedu.examsys.entity.ShortQuestion;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @Description TODO
 * @interfaceName ShortDao
 * @Author Yama
 * @Date 2019/9/2 9:16
 * @Version V1.0
 */
public interface ShortDao {

    /**
     * 批量导入简答题
     * @param shortTitle 传入的对象是一个 ShortQuestion 类对象集合
     */
    public void addShortTitle(@Param("shortTitle") List<ShortQuestion> shortTitle);

    /**
     * 查询所有简答题信息
     * @param subjectName 传入的参数是一学科名称，模糊查询使用
     * @return 返回查询到的信息
     */
    public List<ShortQuestion> findAll(@Param("subjectName") String subjectName);

    /**
     * 查询一条简答题的信息
     * @param sid 传入的参数是一个简答题的 Id
     * @return 返回查询到的信息
     */
    public ShortQuestion findById(Integer sid);

    /**
     * 删除一条简答题
     * @param sid 传入的是简答题的Id
     */
    public void deleteShort(Integer sid);

    /**
     * 修改一条简答题信息
     * @param shortQuestion 传入的参数是一个 ShortQuestion 类对象
     */
    public void modifyShort(ShortQuestion shortQuestion);
}
