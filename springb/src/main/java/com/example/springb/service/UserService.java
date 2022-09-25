package com.example.springb.service;

import com.example.springb.domain.UserVo;
import com.example.springb.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public int userNum(){
        return userMapper.userNum();
    }
    public List<UserVo> userList(){
        return userMapper.findAll();
    }
}
