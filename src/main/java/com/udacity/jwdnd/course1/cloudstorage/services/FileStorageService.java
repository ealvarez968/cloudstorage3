package com.udacity.jwdnd.course1.cloudstorage.services;


import com.udacity.jwdnd.course1.cloudstorage.model.Files;
import com.udacity.jwdnd.course1.cloudstorage.model.FilesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.math.BigInteger;
import java.util.Base64;

@Service
public class FileStorageService {

    @Autowired
    FilesMapper filesMapper;

    public Files storeFile(MultipartFile file, int userid) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new IOException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            Files dbFile = new Files();
            dbFile.setFilename(fileName);
            dbFile.setContenttype(file.getContentType());
            dbFile.setFilesize(file.getSize()+"");
            dbFile.setFiledata(file.getBytes());

            dbFile.setUserid(userid);

            filesMapper.insertFile(dbFile);
            return dbFile;





        } catch (IOException ex) {
           System.out.println("Error al almacenar el archivo");
        }
        return null;
    }

}
