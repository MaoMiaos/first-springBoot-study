package com.ffmsic.dto;

import com.ffmsic.vo.RoleVo;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private String id;

    private String username;

    private String nickname;

    private List<RoleVo> roleVos;
}
