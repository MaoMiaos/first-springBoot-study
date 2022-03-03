package com.ffmusic.service.Impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.ffmusic.config.SecurityConfig;
import com.ffmusic.dto.TokenCreateRequest;
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
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@Service
public class UserServiceImpl extends BaseService implements UserService {

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
        return userMapper.toDto(getById(id));
    }

    @Override
    public UserDto update(String id, UserUpdateRequest userupdaterequest) {
        return userMapper.toDto(userRepository.save(userMapper.updateEntity(getById(id), userupdaterequest)));
    }

    @Override
    public void delete(String id) {
        userRepository.delete(getById(id));
    }

    private User getById(String id) {
        Optional<User> userOptional = userRepository.findById(id);
        if(!userOptional.isPresent()){
            throw new BizException(ExceptionType.USER_NOT_FOUND);
        }
        return userOptional.get();
    }

    @Override
    public Page<UserDto> search(Pageable pageable) {
        return userRepository.findAll(pageable).map(userMapper::toDto);
    }

    @Override
    public User loadUserByUsername(String username) {
        return super.loadUserByUsername(username);
    }

    @Override
    public String createToken(TokenCreateRequest tokenCreateRequest) {
        User user = loadUserByUsername(tokenCreateRequest.getUsername());
        if (!passwordEncoder.matches(tokenCreateRequest.getPassword(), user.getPassword())) {
            throw new BizException(ExceptionType.USER_PASSWORD_NOT_MATCH);
        }
        if (!user.isEnabled()) {
            throw new BizException(ExceptionType.USER_NOT_ENABLED);
        }
        if (!user.isAccountNonLocked()) {
            throw new BizException(ExceptionType.USER_LOCKED);
        }
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), new ArrayList<>());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + SecurityConfig.EXPIRATION_TIME))
                .sign(Algorithm.HMAC512(SecurityConfig.SECRET.getBytes()));
    }

    @Override
    public UserDto getCurrentUser() {
        return userMapper.toDto(super.getCurrentUserEntity());
    }

    private void checkUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            throw new BizException(ExceptionType.USER_NAME_DUPLICATE);
        }
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
