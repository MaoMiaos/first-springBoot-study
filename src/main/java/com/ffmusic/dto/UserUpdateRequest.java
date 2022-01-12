package com.ffmusic.dto;

import com.ffmusic.enums.Gender;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class UserUpdateRequest {
    @NotBlank(message = "用户名不能为空")
    @Size(min = 4,max = 64,message = "用户名长度应该在4个字符到64个字符之间")
    private String username;

    private String nickname;

    private Gender gender;
}
