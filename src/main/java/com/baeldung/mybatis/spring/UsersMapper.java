package com.baeldung.mybatis.spring;

import org.apache.catalina.User;
import org.apache.ibatis.annotations.*;

public interface UsersMapper {

    @Select("SELECT * FROM USERS WHERE userid = #{userid}")
    Users getUsers(@Param("userid") int userid);

    //@Insert("INSERT INTO USERS (userid, username, salt, password, firstname, lastname) values (#{userid},#{username}, #{salt}, #{password}, #{firstname}, #{lastname})")
    /*@Insert("INSERT INTO USERS (userid,  firstname, lastname) values (#{userid}, #{firstname}, #{lastname})")
    void insertUsers(int userid, String firstname, String lastname);*/
    /*@Insert("INSERT INTO USERS (userid,username) values (#{userid}, #{username})")
    void insertUsers(int userid, String username);*/
    @Insert("INSERT INTO USERS (userid, username, salt, password, firstname, lastname) values (#{userid},#{username}, #{salt}, #{password}, #{firstname}, #{lastname})")
    void insertUsers(Users users);



    @Update("UPDATE USERS SET username=#{username}, WHERE userid =#{userid}")
    void updateUsername(String username, int userid);

    @Delete("DELETE FROM USERS WHERE userid =#{userid}")
    void deleteVillage(int userid);

}
