package com.qfedu.examsys.service.impl;

import com.qfedu.examsys.dao.SysDao;
import com.qfedu.examsys.entity.Authority;
import com.qfedu.examsys.service.SysService;
import com.qfedu.examsys.vo.VAuthority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysServiceImpl implements SysService {

    @Autowired(required = false)
    private SysDao sysDao;

    @Override
    public List<VAuthority> findAuthorityById(Integer uid) {
        List<VAuthority> vAuthority = sysDao.query(uid);
        return vAuthority;
    }
}
