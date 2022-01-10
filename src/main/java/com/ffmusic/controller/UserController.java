package com.ffmusic.controller;

import com.ffmusic.dto.UserCreateDto;
import com.ffmusic.mapper.UserMapper;
import com.ffmusic.service.UserService;
import com.ffmusic.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {
    UserService userService;

    UserMapper userMapper;

    @GetMapping("/")
    List<UserVo> list(){
        return userService.list()
                .stream().map(userMapper::toVo).collect(Collectors.toList());
    }
    @PostMapping("/")
    UserVo create(@RequestBody UserCreateDto userCreateDto){
        return userMapper.toVo(userService.create(userCreateDto));
    }
    @PostMapping("/login")
    String getddd(){
        return "111111";
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
