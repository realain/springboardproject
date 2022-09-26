package com.example.springb.mapper;

import com.example.springb.domain.BoardVo;
import com.example.springb.domain.UserVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    int boardNum();

    List<BoardVo> findAll();

    BoardVo findById(int boardIdx)throws Exception;

    UserVo findUserName(int boardIdx)throws Exception;

    int boardDelete(int boardIdx)throws Exception;

    void boardModify(BoardVo boardVo)throws Exception;
}
