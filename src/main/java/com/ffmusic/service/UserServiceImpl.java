package com.ffmusic.service;

import com.ffmusic.dto.UserDto;
import com.ffmusic.mapper.UserMapper;
import com.ffmusic.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class UserServiceImpl implements UserService{

    UserRepository userRepository;

    UserMapper userMapper;
    @Override
    public List<UserDto> list() {
        return userRepository.findAll()
                .stream().map(userMapper::toDto).collect(Collectors.toList());
    }


    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
}
