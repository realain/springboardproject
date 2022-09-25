package com.example.springb.mapper;


import com.example.springb.domain.UserVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    int userNum();

    List<UserVo> findAll();
}
