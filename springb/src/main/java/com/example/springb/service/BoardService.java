package com.example.springb.service;

import com.example.springb.domain.BoardVo;
import com.example.springb.domain.UserVo;
import com.example.springb.mapper.BoardMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class BoardService {

    private final BoardMapper boardMapper;

    public BoardService(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }


    public int boardNum(){
        return boardMapper.boardNum();
    }
    public List<BoardVo> boardList(){
        return boardMapper.findAll();
    }
    public BoardVo findById(int boardIdx){
        return boardMapper.findById(boardIdx);
    }
    public UserVo findUserName(int boardIdx){
        return boardMapper.findUserName(boardIdx);
    }
    public int boardDelete(int boardIdx){
        return boardMapper.boardDelete(boardIdx);
    }
}
