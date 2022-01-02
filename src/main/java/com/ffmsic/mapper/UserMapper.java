package com.ffmsic.mapper;

import com.ffmsic.dto.UserDto;
import com.ffmsic.entity.User;
import com.ffmsic.vo.UserVo;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
//封装成包在Controller使用
@Component
public interface UserMapper {
    UserDto toDto(User user);

    UserVo toVo(UserDto userDto);
}
