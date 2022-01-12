package com.ffmusic.service.Impl;

import com.ffmusic.dto.UserCreateRequest;
import com.ffmusic.dto.UserDto;
import com.ffmusic.dto.UserUpdateRequest;
import com.ffmusic.entity.User;
import com.ffmusic.exception.BizException;
import com.ffmusic.exception.ExceptionType;
import com.ffmusic.mapper.UserMapper;
import com.ffmusic.repository.UserRepository;
import com.ffmusic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    UserMapper userMapper;

    PasswordEncoder passwordEncoder;

    @Override
    public UserDto create(UserCreateRequest userCreateRequest) {
        checkUsername(userCreateRequest.getUsername());
        User user = userMapper.createEntity(userCreateRequest);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userMapper.toDto(userRepository.save(user));
    }
    @Override
    public UserDto get(String id) {
        // Todo: 重构
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent()) {
            throw new BizException(ExceptionType.USER_NOT_FOUND);
        }
       return userMapper.toDto(user.get());
    }

    @Override
    public UserDto update(String id, UserUpdateRequest userupdaterequest) {
        //:Todo:重构
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent()) {
            throw new BizException(ExceptionType.USER_NOT_FOUND);
        }
        return userMapper.toDto(userRepository.save(userMapper.updateEntity(user.get(),userupdaterequest)));
    }

    @Override
    public void delete(String id) {
        //:Todo:重构
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent()) {
            throw new BizException(ExceptionType.USER_NOT_FOUND);
        }
        userRepository.delete(user.get());
    }

    @Override
    public Page<UserDto> search(Pageable pageable) {
        return userRepository.findAll(pageable).map(userMapper::toDto);
    }

    @Override
    public User loadUserByUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        System.out.println("load方法"+user.toString());
        if(!user.isPresent()){ throw new BizException(ExceptionType.USER_NOT_FOUND); }
        return user.get();
    }



    private void checkUsername(String username){
        Optional<User> user = userRepository.findByUsername(username);
        if(user.isPresent()){ throw new BizException(ExceptionType.USER_NAME_DUPLICATE); }
    }
    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
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
