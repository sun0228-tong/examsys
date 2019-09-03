package com.qfedu.examsys.service;

import com.qfedu.examsys.entity.ApplyMessage;

import java.util.List;

/**
 * @ClassName ApplyMessageService
 * @Description 报名信息管理服务层
 * @Author GK
 * @Date 2019/9/2   10:07
 */
public interface ApplyMessageService {

    public void addAms(ApplyMessage applyMessage);

    public void deleteAmsById(Integer aid);

    public void updateAms(ApplyMessage applyMessage);

    public ApplyMessage findAmsById(Integer aid);

    public List<ApplyMessage> findAllAms(Integer page, Integer limit);
}