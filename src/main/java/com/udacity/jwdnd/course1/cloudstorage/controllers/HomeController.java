package com.udacity.jwdnd.course1.cloudstorage.controllers;


import com.udacity.jwdnd.course1.cloudstorage.model.Credentials;
import com.udacity.jwdnd.course1.cloudstorage.model.Files;
import com.udacity.jwdnd.course1.cloudstorage.model.Notes;
import com.udacity.jwdnd.course1.cloudstorage.model.NotesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@ContextConfiguration(locations = "classpath:/beans.xml")
public class HomeController {

    @Autowired
    private NotesMapper notesMapper;

    @PostMapping("/home/notes/add")
    public RedirectView greetingSubmit(@ModelAttribute Notes note, RedirectAttributes attributes) {

        System.out.println("holaaa");
        System.out.println(note.getNotetitle());
        //System.out.println(note.getNotetitle());

        //redirectAttrs.addFlashAttribute("msg", "Successfully did it!");
       /* RedirectView rv = new RedirectView("/home");
        rv.setExposeModelAttributes(false);
        rv.addStaticAttribute("msg", "Successfully did it!");*/
        attributes.addFlashAttribute("alertClass", "success");
        attributes.addFlashAttribute("msg", "Se agrego exitosamente");
       // attributes.addAttribute("attribute", "redirectWithRedirectView");
        return new RedirectView("/home");


        //return "redirect:/";

    }
    /*
    @PostMapping("/home")
    public String greetingSubmit2(@ModelAttribute Files file) {


        return "Ingreso Files";
    }
    */
    @RequestMapping("/home")
    public ModelAndView getHome(@ModelAttribute("alertClass") String alertClass, @ModelAttribute("msg") String msg){

        /*Notes n = new Notes();
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
        notesMapper.getNote(1);*/


        ModelAndView mav = new ModelAndView();
        mav.setViewName("home");
        mav.addObject("notes", notesMapper.getNotes());
        mav.addObject("note", new Notes());
        mav.addObject("file", new Files());
        mav.addObject("credential", new Credentials());
        mav.addObject("msg", msg);
        mav.addObject("alertClass", alertClass);
        return mav;
    }
}
