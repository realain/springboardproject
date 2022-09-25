package com.example.springb.domain;


import lombok.Data;

import java.math.BigInteger;
import java.sql.Date;


@Data
public class UserVo {

    private BigInteger userNum;
    private String userId;
    private String userPw;
    private String userName;
    private String userPhone;
    private Date userInsertDate;
    private int userGrade;

}
