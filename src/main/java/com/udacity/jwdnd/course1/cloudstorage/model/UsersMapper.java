package com.udacity.jwdnd.course1.cloudstorage.model;

import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

@Mapper
public interface UsersMapper {

    @Select("SELECT * FROM USERS WHERE userid = #{userid}")
    Users getUser(@Param("userid") int userid);

    //@Insert("INSERT INTO USERS (userid, username, salt, password, firstname, lastname) values (#{userid},#{username}, #{salt}, #{password}, #{firstname}, #{lastname})")
    /*@Insert("INSERT INTO USERS (userid,  firstname, lastname) values (#{userid}, #{firstname}, #{lastname})")
    void insertUsers(int userid, String firstname, String lastname);*/
    /*@Insert("INSERT INTO USERS (userid,username) values (#{userid}, #{username})")
    void insertUsers(int userid, String username);*/
    @Insert("INSERT INTO USERS (userid, username, salt, password, firstname, lastname) values (#{userid},#{username}, #{salt}, #{password}, #{firstname}, #{lastname})")
    void insertUsers(Users users);

    @Select("SELECT * FROM USERS ")
    ArrayList<Users> getUsers();

    @Update("UPDATE USERS SET username=#{username} WHERE userid =#{userid}")
    void updateUsername(String username, int userid);

    @Delete("DELETE FROM USERS WHERE userid =#{userid}")
    void deleteUser(int userid);

}
