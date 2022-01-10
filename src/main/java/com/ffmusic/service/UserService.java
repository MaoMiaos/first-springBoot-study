package com.ffmusic.service;

import com.ffmusic.dto.UserCreateDto;
import com.ffmusic.dto.UserDto;
import com.ffmusic.entity.User;
import com.ffmusic.vo.UserVo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;


public interface UserService extends UserDetailsService {
    List<UserDto> list();

    UserDto create(UserCreateDto userCreateDto);

    @Override
    User loadUserByUsername(String username) ;
}
