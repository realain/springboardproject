package com.example.springb.controller;

import com.example.springb.domain.BoardVo;
import com.example.springb.service.BoardService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardControllerTest {
    @Autowired BoardController boardController;
    @Autowired BoardService boardService;

    @Test
    @Transactional
    void boardInsert() throws Exception {
        BoardVo boardVo = new BoardVo();
        boardVo.setUserIdx(1L);
        boardVo.setBoardIdx(100);
        boardVo.setTitle("asdf");
        boardVo.setContent("hello");

        boardController.boardInsert(boardVo);

        List<BoardVo> boardVos = boardService.boardList();
        System.out.println(boardVos);
//        Assertions.assertEquals(1, boardVos.size());
//        Assertions.assertEquals(boardVo.getContent(), boardVos.get(0).getContent());
    }
}