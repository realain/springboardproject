package com.example.springb.domain;

import lombok.Data;

import java.math.BigInteger;
import java.sql.Date;

@Data
public class Board {
    private BigInteger userNum;
    private String boardTitle;
    private int boardNum;
    private String boardContent;
    private Date boardInsertDate;
}
