package com.udacity.jwdnd.course1.cloudstorage.model;

public class Users {
    private int userid;
    private String  username;
    private String salt;
    private String password;
    private String firstname;
    private String lastname;

    public String getUsername() {
        return username;
    }

    public String getSalt() {
        return salt;
    }

    public String getPassword() {
        return password;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public int getUserid() {
        return userid;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }


}
