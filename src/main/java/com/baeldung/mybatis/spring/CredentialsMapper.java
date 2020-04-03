package com.baeldung.mybatis.spring;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.ArrayList;

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
