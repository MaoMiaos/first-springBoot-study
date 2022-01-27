package com.ffmusic.vo;

import com.ffmusic.enums.Gender;
import lombok.Data;

import java.util.List;

@Data
public class UserVo {
    private String id;

    private String username;

    private String nickname;

    private Gender gender;

    private boolean locked;

    private boolean enabled;

    private List<RoleVo> roles;
}
