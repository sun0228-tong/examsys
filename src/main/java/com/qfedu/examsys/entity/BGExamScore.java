package com.qfedu.examsys.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName BGExamScore
 * @Description 后台考场分数图使用
 * @Author GK
 * @Date 2019/9/3   16:36
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BGExamScore {

    private Integer eid;
    private Integer score;
}