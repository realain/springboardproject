package com.example.springb.service;

import com.example.springb.domain.CmtVo;
import com.example.springb.domain.UserVo;
import com.example.springb.mapper.CmtMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CmtService {
    private final CmtMapper cmtMapper;

    public CmtService(CmtMapper cmtMapper) {
        this.cmtMapper = cmtMapper;
    }

    public int cmtNum()throws Exception{
        return cmtMapper.cmtNum();
    }
    public List<CmtVo> cmtList() throws Exception {
        return cmtMapper.findAll();
    }
    public List<CmtVo> findById(int cmtIdx)throws Exception{
        return cmtMapper.findById(cmtIdx);
    }
    public UserVo findUserName(int cmtIdx)throws Exception{
        return cmtMapper.findUserName(cmtIdx);
    }
    public int cmtDelete(int cmdIdx)throws Exception{
        return cmtMapper.cmtDelete(cmdIdx);
    }
    public void cmtInsert(CmtVo cmtVo)throws Exception{
        cmtMapper.cmtInsert(cmtVo);
    }
    public void cmtModify(CmtVo cmtVo)throws Exception{
        cmtMapper.cmtModify(cmtVo);
    }
}
