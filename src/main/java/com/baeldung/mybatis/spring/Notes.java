package com.baeldung.mybatis.spring;

public class Notes {

    private int noteid;
    private String notetitle;
    private String notedescription;
    private int userId;

    public int getUserId() {
        return userId;
    }

    public int getNoteid() {
        return noteid;
    }

    public String getNotedescription() {
        return notedescription;
    }

    public String getNotetitle() {
        return notetitle;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setNotedescription(String notedescription) {
        this.notedescription = notedescription;
    }

    public void setNoteid(int noteid) {
        this.noteid = noteid;
    }

    public void setNotetitle(String notetitle) {
        this.notetitle = notetitle;
    }
}
