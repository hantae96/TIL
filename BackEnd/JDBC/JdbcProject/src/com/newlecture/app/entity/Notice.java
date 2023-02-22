package com.newlecture.app.entity;

import java.sql.Date;

public class Notice {
    private int id;
    private String title;
    private String writerId;
    private Date regDate;
    private String content;
    private int hit;
    private String files;

    public Notice(){

    }

    public Notice(int id, String title, String writerId, Date regDate, String content, int hit) {
        this.id = id;
        this.title = title;
        this.writerId = writerId;
        this.regDate = regDate;
        this.content = content;
        this.hit = hit;
        this.files = files;
    }

    public String getFiles() {
        return files;
    }

    public void setFiles(String files) {
        this.files = files;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriterId() {
        return writerId;
    }

    public void setWriterId(String writerId) {
        this.writerId = writerId;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }
}
