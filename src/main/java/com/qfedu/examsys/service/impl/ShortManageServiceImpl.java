package com.qfedu.examsys.service.impl;

import com.qfedu.examsys.dao.ShortManageDao;
import com.qfedu.examsys.entity.ShortManage;
import com.qfedu.examsys.service.ShortManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShortManageServiceImpl implements ShortManageService {
    @Autowired(required = false)
    private ShortManageDao shortManageDao;

    @Override
    public void add(ShortManage shortManage) {
        shortManageDao.add(shortManage);
    }
}
