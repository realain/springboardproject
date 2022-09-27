package com.example.springb.mapper;

import com.example.springb.domain.CmtVo;
import com.example.springb.domain.UserVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CmtMapper {

    int cmtNum()throws Exception;

    List<CmtVo> findAll()throws Exception;

    List<CmtVo> findById(int cmtIdx)throws Exception;

    UserVo findUserName(int cmtIdx)throws Exception;

    int cmtDelete(int cmdIdx)throws Exception;

    void cmtInsert(CmtVo cmtVo)throws Exception;

    void cmtModify(CmtVo cmtVo)throws Exception;
}
