package com.example.springb.vo;


import lombok.Data;
import java.math.BigInteger;
import java.sql.Date;

@Data
public class User {

    private BigInteger userNum;
    private String userId;
    private String userPw;
    private String userName;
    private String userPhone;
    private Date userInsertDate;
    private int userGrade;

}
