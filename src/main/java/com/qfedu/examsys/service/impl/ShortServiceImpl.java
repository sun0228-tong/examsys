package com.qfedu.examsys.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qfedu.examsys.dao.ShortDao;
import com.qfedu.examsys.entity.ShortQuestion;
import com.qfedu.examsys.service.ShortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Name ShortServiceImpl
 * @Author Yama
 * @Date 2019/9/2 9:23
 * @Version V1.0
 */
@Service
public class ShortServiceImpl implements ShortService {

    @Autowired(required = false)
    private ShortDao shortDao;
    @Override
    public void addShortTitle(List<ShortQuestion> shortTitle) {
        shortDao.addShortTitle(shortTitle);
    }

    @Override
    public Map<String, Object> findAll(String subjectName,
                                       Integer page,
                                       Integer limit) {
        // 设置页码和每页显示的记录数，该语句后，跟着数据库查询相关的语句
        PageHelper.startPage(page, limit);

        List<ShortQuestion> list = shortDao.findAll(subjectName);
        Map<String, Object> map = new HashMap<>();
        long total = ((Page) list).getTotal();
        map.put("code", 0);
        map.put("msg", "");
        // 表中总记录
        map.put("count", total);
        // 获取到的分页数据
        map.put("data", list);
        return map;
    }

    @Override
    public ShortQuestion findById(Integer sid) {
        return shortDao.findById(sid);
    }

    @Override
    public void deleteShort(Integer sid) {
        shortDao.deleteShort(sid);
    }

    @Override
    public void modifyShort(ShortQuestion shortQuestion) {
        shortDao.modifyShort(shortQuestion);
    }
}
