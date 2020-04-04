package com.udacity.jwdnd.course1.cloudstorage.model;


import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

@Mapper
public interface NotesMapper {

    @Select("SELECT * FROM NOTES WHERE noteid = #{noteid}")
    Notes getNote(@Param("noteid") int noteid);

    @Select("SELECT * FROM NOTES ")
    ArrayList<Notes> getNotes();

    @Update("UPDATE NOTES SET notetitle=#{notetitle} WHERE noteid =#{noteid}")
    void updateNoteTitle(String notetitle, int noteid);

    @Update("UPDATE NOTES SET notedescription=#{notedescription} WHERE noteid =#{noteid}")
    void updateNoteDescription(String notedescription, int noteid);

    @Insert("INSERT INTO NOTES (noteid, notetitle, notedescription, userid) values (#{noteid},#{notetitle}, #{notedescription}, #{userid})")
    void insertUsers(Notes notes);


    @Delete("DELETE FROM NOTES WHERE noteid =#{noteid}")
    void deleteNote(int noteid);
}