package com.ffmusic.controller;

import com.ffmusic.mapper.UserMapper;
import com.ffmusic.service.UserService;
import com.ffmusic.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/users")
public class UserController {
    UserService userService;

    UserMapper userMapper;

    @GetMapping("/")
    List<UserVo> list(){
        return userService.list()
                .stream().map(userMapper::toVo).collect(Collectors.toList());
    }

    //提供set方法.当需要useService时再去进行注入操作
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
}
