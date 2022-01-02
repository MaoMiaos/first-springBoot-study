package com.ffmusic.repository;

import com.ffmusic.entity.User;
import com.ffmusic.enums.Gender;
import com.github.ksuid.KsuidGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    void textuser() {
        User user = new User();
        user.setUsername("123");
        user.setNickname("1233");
        user.setPassword("123");
        user.setEnabled(true);
        user.setLocked(false);
        user.setGender(Gender.MALE);
        user.setLastLoginIp("127.0.0.1");
        user.setLastLoginTime(new Date());

        User user1 = userRepository.save(user);
        System.out.println(user1.toString());

    }
}