package com.ffmusic.mapper;

import com.ffmusic.dto.UserCreateRequest;
import com.ffmusic.dto.UserDto;
import com.ffmusic.dto.UserUpdateRequest;
import com.ffmusic.entity.User;
import com.ffmusic.vo.UserVo;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
//封装成包在Controller使用
@Component
public interface UserMapper {
    UserDto toDto(User user);

    UserVo toVo(UserDto userDto);

    User createEntity(UserCreateRequest userCreateRequest);

    User updateEntity(@MappingTarget User user, UserUpdateRequest userUpdateRequest);
}
