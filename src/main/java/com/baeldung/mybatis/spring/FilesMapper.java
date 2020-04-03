package com.baeldung.mybatis.spring;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.ArrayList;

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
