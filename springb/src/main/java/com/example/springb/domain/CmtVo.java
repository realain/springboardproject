package com.example.springb.domain;


import java.time.LocalDateTime;


public class CmtVo {
    private int cmtIdx;
    private Long userIdx;
    private String content;
    private int boardIdx;
    private LocalDateTime insertdate;
    private int parent;
    private int floor;
    private int cmtorder;
    private int group;

    public int getCmtIdx() {
        return cmtIdx;
    }

    public void setCmtIdx(int cmtIdx) {
        this.cmtIdx = cmtIdx;
    }

    public Long getUserIdx() {
        return userIdx;
    }

    public void setUserIdx(Long userIdx) {
        this.userIdx = userIdx;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getBoardIdx() {
        return boardIdx;
    }

    public void setBoardIdx(int boardIdx) {
        this.boardIdx = boardIdx;
    }

    public LocalDateTime getInsertdate() {
        return insertdate;
    }

    public void setInsertdate(LocalDateTime insertdate) {
        this.insertdate = insertdate;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getCmtorder() {
        return cmtorder;
    }

    public void setCmtorder(int cmtorder) {
        this.cmtorder = cmtorder;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "CmtVo{" +
                "cmtIdx=" + cmtIdx +
                ", userIdx=" + userIdx +
                ", content='" + content + '\'' +
                ", boardIdx=" + boardIdx +
                ", insertdate=" + insertdate +
                ", parent=" + parent +
                ", floor=" + floor +
                ", cmtorder=" + cmtorder +
                ", group=" + group +
                '}';
    }
}
