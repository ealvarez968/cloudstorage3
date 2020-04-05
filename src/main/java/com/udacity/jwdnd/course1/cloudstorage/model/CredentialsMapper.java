package com.udacity.jwdnd.course1.cloudstorage.model;

import org.apache.ibatis.annotations.*;

import java.util.ArrayList;


@Mapper
public interface CredentialsMapper {

    @Select("SELECT * FROM CREDENTIALS WHERE credentialid = #{credentialid} and userid = #{userid}")
    Credentials getCredential(@Param("credentialid") int credentialid, @Param("userid") int userid);

    @Select("SELECT * FROM CREDENTIALS ")
    ArrayList<Credentials> getCredentials();

    @Select("SELECT * FROM CREDENTIALS WHERE userid = #{userid}")
    ArrayList<Credentials> getCredentialsByUserid(@Param("userid") int userid);


    @Update("UPDATE CREDENTIALS SET key=#{key} WHERE credentialid =#{credentialid}")
    void updateKey(String key, int credentialid);

    @Update("UPDATE CREDENTIALS SET password=#{password} WHERE credentialid =#{credentialid}")
    void updatePassword(String password, int credentialid);


    @Delete("DELETE FROM CREDENTIALS WHERE credentialid =#{credentialid} and  userid =#{userid}")
    void deleteCredential(int credentialid, int userid);

    @Insert("INSERT INTO CREDENTIALS (url, username, key, password, userid) values (#{url}, #{username}, #{key}, #{password},#{userid})")
    void insertNote(Credentials credentials);

    @Update("UPDATE CREDENTIALS SET url=#{url}, username=#{username} , password=#{password} WHERE credentialid =#{credentialid} and userid =#{userid}")
    void updateCredential(String url, String username, String password, int credentialid, int userid);

}
