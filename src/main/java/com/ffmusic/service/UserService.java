package com.ffmusic.service;

import com.ffmusic.dto.TokenCreateRequest;
import com.ffmusic.dto.UserCreateRequest;
import com.ffmusic.dto.UserDto;
import com.ffmusic.dto.UserUpdateRequest;
import com.ffmusic.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService {

    UserDto create(UserCreateRequest userCreateRequest);

    @Override
    User loadUserByUsername(String username);

    UserDto get(String id);

    UserDto update(String id, UserUpdateRequest userupdaterequest);

    void delete(String id);

    Page<UserDto> search(Pageable pageable);

    String createToken(TokenCreateRequest createRequest);

    UserDto getCurrentUser();
}
