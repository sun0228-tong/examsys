package com.qfedu.examsys.vo;

import com.qfedu.examsys.entity.ExamManage;
import com.qfedu.examsys.entity.Student;
import com.qfedu.examsys.entity.Subject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName VApplyMessage
 * @Description 报名信息管理 vo 类
 * @Author GK
 * @Date 2019/9/2   9:54
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VApplyMessage {
   private Integer aid;
   private Integer sid;
   private String studentName;
   private String sex;
   private String email;
   private String phone;
   private String subjectName;
   private Date examStart;
   private Date examEnd;
   private String examTime;
   private Student student;
   private Subject subject;
   private ExamManage examManage;
}