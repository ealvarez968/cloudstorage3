package com.udacity.jwdnd.course1.cloudstorage.model;

public class Notes {

    private int noteid;
    private String notetitle;
    private String notedescription;
    private int userid;

    public int getUserid() {
        return userid;
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

    public void setUserid(int userid) {
        this.userid = userid;
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
