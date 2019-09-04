package com.qfedu.examsys.vo;

import lombok.Data;

/**
 * @ClassName VScoreManage
 * @Description TODO
 * @Author wangzhendong
 * @Date 2019/9/2
 */
@Data
public class VScoreManage {
    private Integer sid;
    private Integer studentId;
    private VApplyMessage vApplyMessage;
    private String score;
}
