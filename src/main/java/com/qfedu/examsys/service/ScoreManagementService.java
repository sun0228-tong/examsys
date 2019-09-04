package com.qfedu.examsys.service;

import java.util.Map;

public interface ScoreManagementService {
    Map<String, Object> findAllScoreManage(Integer page, Integer limit, Integer sid);
}
