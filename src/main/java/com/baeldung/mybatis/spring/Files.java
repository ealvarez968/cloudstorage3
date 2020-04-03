package com.baeldung.mybatis.spring;

public class Files {

    private int fileid;
    private String filenam;
    private String contenttype;
    private String filesize;
    private int userid;
    //Mapped to java.sql.Blob (java.io.InputStream is also supported).
    private String filedata;

    public int getUserid() {
        return userid;
    }

    public int getFileid() {
        return fileid;
    }

    public String getContenttype() {
        return contenttype;
    }

    public String getFiledata() {
        return filedata;
    }

    public String getFilenam() {
        return filenam;
    }

    public String getFilesize() {
        return filesize;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public void setContenttype(String contenttype) {
        this.contenttype = contenttype;
    }

    public void setFiledata(String filedata) {
        this.filedata = filedata;
    }

    public void setFileid(int fileid) {
        this.fileid = fileid;
    }

    public void setFilenam(String filenam) {
        this.filenam = filenam;
    }

    public void setFilesize(String filesize) {
        this.filesize = filesize;
    }

}
