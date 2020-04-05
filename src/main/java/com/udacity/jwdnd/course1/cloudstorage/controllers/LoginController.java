package com.udacity.jwdnd.course1.cloudstorage.controllers;

import com.udacity.jwdnd.course1.cloudstorage.model.Users;
import com.udacity.jwdnd.course1.cloudstorage.model.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@RestController
public class LoginController implements WebMvcConfigurer {

    @Autowired
    UsersMapper usersMapper;

    @RequestMapping("/login")
    public ModelAndView getLogin(){

        for(Users u : usersMapper.getUsers()){
            System.out.println("username "+u.getUsername()+ " Password: "+u.getPassword());

        }
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login");
        return mav;
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseTrailingSlashMatch(true);
    }
}
