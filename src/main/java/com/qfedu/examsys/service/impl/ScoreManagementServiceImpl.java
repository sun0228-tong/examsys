package com.qfedu.examsys.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qfedu.examsys.dao.ScoreManagementDao;
import com.qfedu.examsys.entity.Subject;
import com.qfedu.examsys.service.ScoreManagementService;
import com.qfedu.examsys.vo.VScoreManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ScoreManagementServiceImpl
 * @Description TODO
 * @Author wangzhendong
 * @Date 2019/9/2
 */
@Service
public class ScoreManagementServiceImpl implements ScoreManagementService {

    @Autowired(required = false)
    private ScoreManagementDao scoreManagementDao;

    @Override
    public Map<String, Object> findAllScoreManage(Integer page, Integer limit, String studentName, String subjectName, Integer eid) {

        HashMap<Object, Object> map1 = new HashMap<>();
        map1.put("studentName", studentName);
        map1.put("subjectName", subjectName);
        map1.put("eid", eid);


        //在执行的SQL语句后面拼上分页
        PageHelper.startPage(page, limit);

        List<VScoreManage> scoreManage = scoreManagementDao.findAllScoreManage(map1);

        //获取总数据条数
        long total = ((Page) scoreManage).getTotal();
        if (scoreManage != null && scoreManage.size() != 0) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("code", 0);
            map.put("msg", "");
            map.put("count", total);
            map.put("data", scoreManage);
            return map;
        } else {
            HashMap<String, Object> map = new HashMap<>();
            map.put("code", 0);
            map.put("msg", "");
            map.put("count", total);
            map.put("data", "没有数据");
            return map;
        }
    }

    @Override
    public Map<String, Object> findByIdScoreManage(Integer sid) {
        VScoreManage vScoreManage = scoreManagementDao.findByIdScoreManage(sid);
        if (vScoreManage != null ) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("code", 0);
            map.put("info", vScoreManage);
            return map;
        } else {
            HashMap<String, Object> map = new HashMap<>();
            map.put("code", 1);
            map.put("info", "查询失败");
            return map;
        }
    }

    @Override
    public Map<String, Object> findAllSubject() {
        List<Subject> subject = scoreManagementDao.findAllSubject();
        if (subject != null) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("code", 0);
            map.put("info", subject);
            return map;
        } else {
            HashMap<String, Object> map = new HashMap<>();
            map.put("code", 1);
            map.put("info", "查询失败");
            return map;
        }
    }

    @Override
    public Map<String, Object> updateScoreManage(VScoreManage vScoreManage) {
        int manage = scoreManagementDao.updateScoreManage(vScoreManage);
        if (manage != 0) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("code", 0);
            map.put("info", "修改成功");
            return map;
        } else {
            HashMap<String, Object> map = new HashMap<>();
            map.put("code", 1);
            map.put("info", "修改失败");
            return map;
        }
    }
}
