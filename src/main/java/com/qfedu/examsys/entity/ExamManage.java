package com.qfedu.examsys.entity;

import java.util.Date;

/**
 * @ClassName ExamManage 考试发布信息表
 * @Description ExamManage 考试发布的信息表的实体类对象
 * @Author wangzhendong
 * @Date 2019/8/29
 */
public class ExamManage {
    private Integer eid;
    private Integer subjectId;
    private Date applyStart;
    private Date applyEnd;
    private Date examStart;
    private Date examEnd;
    private Date examTime;

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public Date getApplyStart() {
        return applyStart;
    }

    public void setApplyStart(Date applyStart) {
        this.applyStart = applyStart;
    }

    public Date getApplyEnd() {
        return applyEnd;
    }

    public void setApplyEnd(Date applyEnd) {
        this.applyEnd = applyEnd;
    }

    public Date getExamStart() {
        return examStart;
    }

    public void setExamStart(Date examStart) {
        this.examStart = examStart;
    }

    public Date getExamEnd() {
        return examEnd;
    }

    public void setExamEnd(Date examEnd) {
        this.examEnd = examEnd;
    }

    public Date getExamTime() {
        return examTime;
    }

    public void setExamTime(Date examTime) {
        this.examTime = examTime;
    }
}
