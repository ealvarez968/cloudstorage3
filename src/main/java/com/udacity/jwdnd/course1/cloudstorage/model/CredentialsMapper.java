package com.udacity.jwdnd.course1.cloudstorage.model;

import org.apache.ibatis.annotations.*;

import java.util.ArrayList;


@Mapper
public interface CredentialsMapper {

    @Select("SELECT * FROM CREDENTIALS WHERE credentialid = #{credentialid}")
    Credentials getCredential(@Param("credentialid") int credentialid);

    @Select("SELECT * FROM CREDENTIALS ")
    ArrayList<Credentials> getCredentials();

    @Update("UPDATE CREDENTIALS SET key=#{key} WHERE credentialid =#{credentialid}")
    void updateKey(String key, int credentialid);

    @Update("UPDATE CREDENTIALS SET password=#{password} WHERE credentialid =#{credentialid}")
    void updatePassword(String password, int credentialid);


    @Delete("DELETE FROM CREDENTIALS WHERE credentialid =#{credentialid}")
    void deleteCredential(int credentialid);
}
