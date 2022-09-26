package com.example.springb.domain;



import java.time.LocalDateTime;

public class UserVo {

    private Long userIdx;
    private String id;
    private String pw;
    private String name;
    private String phone;
    private LocalDateTime insertdate;
    private int grade;

    public Long getUserIdx() {
        return userIdx;
    }

    public void setUserIdx(Long userIdx) {
        this.userIdx = userIdx;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDateTime getInsertdate() {
        return insertdate;
    }

    public void setInsertdate(LocalDateTime insertdate) {
        this.insertdate = insertdate;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "UserVo{" +
                "userIdx=" + userIdx +
                ", id='" + id + '\'' +
                ", pw='" + pw + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", insertdate=" + insertdate +
                ", grade=" + grade +
                '}';
    }
}
