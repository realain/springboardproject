package com.example.springb.domain;

import lombok.Data;

import java.math.BigInteger;
import java.sql.Date;

@Data
public class Cmt {
    private int cmtNum;
    private BigInteger userNum;
    private String cmtContent;
    private int boardNum;
    private Date cmtInsertDate;
    private int cmtParent;
    private int cmtFloor;
    private int cmtOrder;
    private int cmtGroup;
}
