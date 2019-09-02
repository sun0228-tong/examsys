package com.qfedu.examsys.vo;

import com.qfedu.examsys.entity.ExamManage;
import com.qfedu.examsys.entity.Student;
import com.qfedu.examsys.entity.Subject;
import lombok.Data;

/**
 * @ClassName VApplyMessage
 * @Description VApplyMessage 的实体类对象
 * @Author wangzhendong
 * @Date 2019/8/30
 */
@Data
public class VApplyMessage {
    private Integer aid;
    private Subject subject;
    private Student student;
    private ExamManage examManage;
}
