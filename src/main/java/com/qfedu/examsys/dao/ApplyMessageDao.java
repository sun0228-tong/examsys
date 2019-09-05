package com.qfedu.examsys.dao;

import com.qfedu.examsys.entity.ApplyMessage;

import java.util.List;

/**
 * @ClassName ApplyMessageDao
 * @Description 报名信息管理 Dao 层
 * @Author GK
 * @Date 2019/9/2   9:43
 */
public interface ApplyMessageDao {

    public void add(ApplyMessage applyMessage);

    public void deleteById(Integer aid);

    public void update(ApplyMessage applyMessage);

    public ApplyMessage findById(Integer aid);

    public List<ApplyMessage> findAllByPage();
}