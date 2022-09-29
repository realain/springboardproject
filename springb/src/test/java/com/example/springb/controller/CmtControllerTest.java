package com.example.springb.controller;

import com.example.springb.domain.CmtVo;
import com.example.springb.service.CmtService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


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
        cmtVo.setUserIdx(1);
        cmtVo.setCmtgroup(1);
        cmtVo.setContent("넣을거");
        cmtVo.setParent(2);
        cmtVo.setBoardIdx(1);
        cmtVo.setFloor(1);
        cmtVo.setCmtorder(0);

        cmtController.cInsert(cmtVo);



    }
}