package com.qfedu.examsys.dao;

import com.qfedu.examsys.entity.Authority;
import com.qfedu.examsys.vo.VAuthority;

import java.util.List;

public interface SysDao {

    public List<VAuthority> query(Integer uid);
}
