package com.udacity.jwdnd.course1.cloudstorage.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class LoginController {

    @RequestMapping("/login")
    public ModelAndView getLogin(){


        ModelAndView mav = new ModelAndView();
        mav.setViewName("login");
        return mav;
    }
}
