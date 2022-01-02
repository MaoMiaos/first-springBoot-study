package com.ffmusic.vo;

import lombok.Data;

import java.util.List;

@Data
public class UserVo {
    private String id;

    private String username;

    private String nickname;

    private List<RoleVo> roleVos;
}
