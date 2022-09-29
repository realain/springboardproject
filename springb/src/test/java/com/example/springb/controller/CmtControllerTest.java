package com.example.springb.controller;

import com.example.springb.domain.CmtVo;
import com.example.springb.service.CmtService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CmtControllerTest {

    @Autowired
    CmtService cmtService;
    @Autowired
    CmtController cmtController;

    @Test
    @Transactional
    void cInsert() throws Exception{
        CmtVo cmtVo =new CmtVo();
        /*LocalDateTime date1 = LocalDateTime.now();
        cmtVo.setInsertdate(date1);*/
        cmtVo.setUserIdx(1L);
        cmtVo.setCmtgroup(0);
        cmtVo.setCmtIdx(7);
        cmtVo.setContent("넣을거");
        cmtVo.setParent(7);
        cmtVo.setBoardIdx(1);
        cmtVo.setFloor(3);
        cmtVo.setCmtorder(5);

        cmtController.cInsert(cmtVo);



    }
}