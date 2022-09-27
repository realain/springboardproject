package com.example.springb.service;

import com.example.springb.domain.BoardVo;
import com.example.springb.domain.UserVo;
import com.example.springb.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
@Transactional
public class BoardService {

    private final BoardMapper boardMapper;

    public BoardService(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }


    public int boardNum()throws Exception{
        return boardMapper.boardNum();
    }
    public List<BoardVo> boardList()throws Exception{
        return boardMapper.findAll();
    }
    public BoardVo findById(int boardIdx)throws Exception{
        return boardMapper.findById(boardIdx);
    }
    public UserVo findUserName(int boardIdx)throws Exception{
        return boardMapper.findUserName(boardIdx);
    }
    public int boardDelete(int boardIdx)throws Exception{
        return boardMapper.boardDelete(boardIdx);
    }
    public void boardModify(BoardVo boardVo)throws Exception{
        boardMapper.boardModify(boardVo);
    }

    public void boardInsert(BoardVo boardVo)throws Exception{
        boardMapper.boardInsert(boardVo);
    }
}
