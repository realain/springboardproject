package com.example.springb.mapper;

import com.example.springb.domain.BoardVo;
import com.example.springb.domain.UserVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BoardMapper {

    int boardNum();

    List<BoardVo> findAll();

    BoardVo findById(int boardIdx);

    UserVo findUserName(int boardIdx);

    public int boardDelete(int boardIdx);
}
