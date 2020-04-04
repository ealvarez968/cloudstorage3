package com.udacity.jwdnd.course1.cloudstorage.model;

import org.apache.ibatis.annotations.*;

import java.util.ArrayList;


@Mapper
public interface FilesMapper {

    @Select("SELECT * FROM FILES WHERE fileid = #{fileid}")
    Files getFile(@Param("fileid") int fileid);

    @Select("SELECT * FROM FILES ")
    ArrayList<Files> getFiles();

    @Update("UPDATE FILES SET filename=#{filename} WHERE fileid =#{fileid}")
    void updateFilename(String filename, int fileid);


    @Delete("DELETE FROM FILES WHERE fileid =#{fileid}")
    void deleteCredential(int fileid);

}
