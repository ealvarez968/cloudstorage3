package com.udacity.jwdnd.course1.cloudstorage.controllers;


import com.baeldung.mybatis.spring.Notes;
import com.baeldung.mybatis.spring.NotesMapper;
import com.baeldung.mybatis.spring.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@ContextConfiguration(locations = "classpath:/beans.xml")
public class HomeController {

    @Autowired
    private NotesMapper notesMapper;

    @RequestMapping("/home")
    public ModelAndView getHome(Model m ){
        Notes n = new Notes();
        n.setNotetitle("Titulo");
        n.setNoteid(1);
        n.setNotedescription("Descrip");

        Notes n2 = new Notes();
        n2.setNotetitle("Titulo");
        n2.setNoteid(2);
        n2.setNotedescription("Descrip");

        Notes n3 = new Notes();
        n3.setNotetitle("Titulo");
        n3.setNoteid(3);
        n3.setNotedescription("Descrip");

        notesMapper.insertUsers(n);
        notesMapper.insertUsers(n2);
        notesMapper.insertUsers(n3);


        ModelAndView mav = new ModelAndView();
        mav.setViewName("home");
        return mav;
    }
}
