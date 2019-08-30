package com.qfedu.examsys.vo;

import com.qfedu.examsys.entity.Authority;
import lombok.Data;

import java.util.List;

@Data
public class VAuthority {
    private String pmenu;
    private List<Authority> listAuthority;
}
