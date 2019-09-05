package com.qfedu.examsys.service;

import com.qfedu.examsys.common.Testpaper;

public interface ExaminationService {
    public Testpaper generate(Integer subjectId);
}
