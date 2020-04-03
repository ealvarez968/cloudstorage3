package com.baeldung.mybatis.spring;

public class Credentials {

    private int credentialid;
    private String url;
    private String username;
    private String key;
    private String password;
    private int userid;

    public int getUserid() {
        return userid;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public int getCredentialid() {
        return credentialid;
    }

    public String getKey() {
        return key;
    }

    public String getUrl() {
        return url;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setCredentialid(int credentialid) {
        this.credentialid = credentialid;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}

