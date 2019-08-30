package com.qfedu.examsys.service;

import com.qfedu.examsys.entity.Authority;
import com.qfedu.examsys.vo.VAuthority;

import java.util.List;

public interface SysService {

    public List<VAuthority> findAuthorityById(Integer uid);
}
