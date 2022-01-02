package com.ffmsic.repository;

import com.ffmsic.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;
    @Test
    void findByUsername() {
    }
}