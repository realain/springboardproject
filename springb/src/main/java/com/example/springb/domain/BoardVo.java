package com.example.springb.domain;



import java.time.LocalDateTime;

public class BoardVo {
    private Long userIdx;
    private String title;
    private int boardIdx;
    private String content;
    private LocalDateTime insertdate;

    public Long getUserIdx() {
        return userIdx;
    }

    public void setUserIdx(Long userIdx) {
        this.userIdx = userIdx;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getBoardIdx() {
        return boardIdx;
    }

    public void setBoardIdx(int boardIdx) {
        this.boardIdx = boardIdx;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getInsertdate() {
        return insertdate;
    }

    public void setInsertdate(LocalDateTime insertdate) {
        this.insertdate = insertdate;
    }

    @Override
    public String toString() {
        return "BoardVo{" +
                "userIdx=" + userIdx +
                ", title='" + title + '\'' +
                ", boardIdx=" + boardIdx +
                ", content='" + content + '\'' +
                ", insertdate=" + insertdate +
                '}';
    }
}
