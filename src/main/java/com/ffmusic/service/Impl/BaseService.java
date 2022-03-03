package com.ffmusic.service.Impl;

import com.ffmusic.entity.User;
import com.ffmusic.exception.BizException;
import com.ffmusic.exception.ExceptionType;
import com.ffmusic.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;
public abstract class BaseService {
    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    public void setUserRepository(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    protected User getCurrentUserEntity() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // todo
        return loadUserByUsername(authentication.getName());
    }

    protected User loadUserByUsername(String username) {
        userRepository.findAll();
        Optional<User> user = userRepository.findByUsername(username);
        if (!user.isPresent()) {
            throw new BizException(ExceptionType.USER_NOT_FOUND);
        }
        return user.get();
    }
}