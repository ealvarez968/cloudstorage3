package com.udacity.jwdnd.course1.cloudstorage.model;

public class Files {

    private int fileid;
    private String filename;
    private String contenttype;
    private String filesize;
    private int userid;
    private byte[] filedata;


    public int getUserid() {
        return userid;
    }

    public int getFileid() {
        return fileid;
    }

    public String getContenttype() {
        return contenttype;
    }

    public byte[] getFiledata() {
        return filedata;
    }

    public String getFilename() {
        return filename;
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

    public void setFiledata(byte[] filedata) {
        this.filedata = filedata;
    }

    public void setFileid(int fileid) {
        this.fileid = fileid;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public void setFilesize(String filesize) {
        this.filesize = filesize;
    }

}
