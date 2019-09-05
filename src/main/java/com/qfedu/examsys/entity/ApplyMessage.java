package com.qfedu.examsys.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName ApplyMessage
 * @Description 报名信息管理实体类
 * @Author GK
 * @Date 2019/9/2   9:39
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplyMessage {
    private Integer aid;
    private Integer subjectId;
    private Integer studentId;
    private Integer examManageId;
}