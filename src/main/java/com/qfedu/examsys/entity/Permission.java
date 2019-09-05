package com.qfedu.examsys.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @ClassName Permission
 * @Description TODO
 * @Author wangzhendong
 * @Date 2019/9/4
 */
@Data
public class Permission {
    private Integer id;
    @JsonProperty("pId")
    private Integer pId;
    private String name;
}
