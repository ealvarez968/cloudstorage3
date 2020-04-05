package com.udacity.jwdnd.course1.cloudstorage.model;

public class Roles {

    private int roleid;
    private String name;
    private int userid;

    public int getUserid() {
        return userid;
    }

    public int getRoleid() {
        return roleid;
    }

    public String getName() {
        return name;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }
}
