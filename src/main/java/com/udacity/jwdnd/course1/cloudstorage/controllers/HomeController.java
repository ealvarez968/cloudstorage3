package com.udacity.jwdnd.course1.cloudstorage.controllers;


import com.udacity.jwdnd.course1.cloudstorage.model.Notes;
import com.udacity.jwdnd.course1.cloudstorage.model.NotesMapper;
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
        n.setNotetitle("Titulo 1 verdad");
        n.setNoteid(1);
        n.setNotedescription("Descrip111111111111111");
        n.setUserid(1);


        Notes n2 = new Notes();
        n2.setNotetitle("Titulo222222");
        n2.setNoteid(2);
        n2.setNotedescription("Descripasdfasdfasdfasdf");
        n2.setUserid(1);

        Notes n3 = new Notes();
        n3.setNotetitle("Titulo333333");
        n3.setNoteid(3);
        n3.setNotedescription("Descripzzzzzzzzzzzzzz");
        n3.setUserid(1);

        notesMapper.insertUsers(n);
        notesMapper.insertUsers(n2);
        notesMapper.insertUsers(n3);
        notesMapper.getNote(1);


        ModelAndView mav = new ModelAndView();
        mav.setViewName("home");
        mav.addObject("notes", notesMapper.getNotes());
        return mav;
    }
}
