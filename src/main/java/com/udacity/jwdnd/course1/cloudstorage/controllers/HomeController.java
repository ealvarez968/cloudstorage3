package com.udacity.jwdnd.course1.cloudstorage.controllers;


import com.udacity.jwdnd.course1.cloudstorage.config.Constant;
import com.udacity.jwdnd.course1.cloudstorage.model.*;
import com.udacity.jwdnd.course1.cloudstorage.services.EncryptionService;
import com.udacity.jwdnd.course1.cloudstorage.services.FileStorageService;
import com.udacity.jwdnd.course1.cloudstorage.services.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.crypto.Cipher;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

@RestController
@ContextConfiguration(locations = "classpath:/beans.xml")
public class HomeController {

    @Autowired
    private NotesMapper notesMapper;
    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private CredentialsMapper credentialsMapper;

    private EncryptionService es;

    @PostMapping("/home/notes/add")
    public RedirectView notes(@ModelAttribute Notes note, RedirectAttributes attributes,@RequestParam(defaultValue="-1") int noteId) {
        String _sessionUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        Users _user = usersMapper.getUserByUsername(_sessionUsername);

        System.out.println("Ingresoooo "+noteId);

        if(_user == null){

            attributes.addFlashAttribute("alertClass", "danger");
            attributes.addFlashAttribute("msg", "Error on session ID.");
            return new RedirectView("/home");

        }

        if(note.getNotetitle().trim().length() == 0
                || note.getNotedescription().trim().length() == 0){

            attributes.addFlashAttribute("alertClass", "danger");
            attributes.addFlashAttribute("msg", "An Error ocurred while creating your note.");
            return new RedirectView("/home");

        }

        attributes.addFlashAttribute("alertClass", "success");


        if(noteId == -1){
            Notes n = new Notes();
            n.setUserid(_user.getUserid());
            n.setNotetitle(note.getNotetitle());
            n.setNotedescription(note.getNotedescription());

            notesMapper.insertNote(n);

            attributes.addFlashAttribute("msg", "Your note "+note.getNotetitle()+" has been added successfully");
            return new RedirectView("/home");

        }

        attributes.addFlashAttribute("msg", "Your note "+note.getNotetitle()+" has been updated successfully");

        notesMapper.updateNote(note.getNotetitle(),note.getNotedescription(),noteId);

        return new RedirectView("/home");

    }


    @PostMapping("/home/credential/add")
    public RedirectView credentials(@ModelAttribute Credentials credential, RedirectAttributes attributes, @RequestParam(defaultValue="-1") int credentialId) {
        String _sessionUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        Users _user = usersMapper.getUserByUsername(_sessionUsername);

        if(_user == null){

            attributes.addFlashAttribute("alertClass", "danger");
            attributes.addFlashAttribute("msg", "Error on session ID.");
            return new RedirectView("/home");

        }

        if(credential.getPassword().trim().length() == 0
                || credential.getUrl().trim().length() == 0
                || credential.getUsername().trim().length() == 0){

            attributes.addFlashAttribute("alertClass", "danger");
            attributes.addFlashAttribute("msg", "An Error ocurred while creating your credential.");
            return new RedirectView("/home");

        }
        attributes.addFlashAttribute("alertClass", "success");

        if(credentialId == -1){
            String key = es.generateRandomSpecialCharacters(Constant.KEY_LENGTH);
            Credentials newCredential = new Credentials();

            newCredential.setUserid(_user.getUserid());
            newCredential.setKey(key);
            System.out.println("key");
            System.out.println(key);
            newCredential.setUrl(credential.getUrl());
            newCredential.setUsername(credential.getUsername());
            newCredential.setPassword( es.encryptValue(credential.getPassword(),key));

            credentialsMapper.insertNote(newCredential);

            attributes.addFlashAttribute("msg", "Your credential for "+newCredential.getUrl()+" has been added successfully");
            return new RedirectView("/home");

        }

        Credentials oldCredential = credentialsMapper.getCredential(credentialId, _user.getUserid());

        attributes.addFlashAttribute("msg", "Your credential for "+credential.getUrl()+" has been updated successfully");

        credentialsMapper.updateCredential(credential.getUrl(),credential.getUsername(),
                es.encryptValue(credential.getPassword(), oldCredential.getKey()),credentialId,_user.getUserid());
        //notesMapper.updateNote(note.getNotetitle(),note.getNotedescription(),noteId);




        return new RedirectView("/home");
    }

    @GetMapping("/home/notes/delete/{noteid}")
    public RedirectView deleteNote( @PathVariable("noteid") int noteid,  RedirectAttributes attributes){
        String _sessionUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        Users _user = usersMapper.getUserByUsername(_sessionUsername);

        Notes n = notesMapper.getNote(noteid, _user.getUserid());

        if(_user == null){
            attributes.addFlashAttribute("alertClass", "danger");
            attributes.addFlashAttribute("msg", "Note not found.");
            return new RedirectView("/home");
        }
        attributes.addFlashAttribute("alertClass", "success");
        attributes.addFlashAttribute("msg", "Your note "+n.getNotetitle()+" has been deleted successfully");

        notesMapper.deleteNote(n.getNoteid(), _user.getUserid());

        return new RedirectView("/home");

    }

    @GetMapping("/home/credentials/delete/{credentialid}")
    public RedirectView deleteCredential( @PathVariable("credentialid") int credentialid,  RedirectAttributes attributes){
        String _sessionUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        Users _user = usersMapper.getUserByUsername(_sessionUsername);

        if(_user == null){
            attributes.addFlashAttribute("alertClass", "danger");
            attributes.addFlashAttribute("msg", "Credential not found.");
            return new RedirectView("/home");
        }

        Credentials n = credentialsMapper.getCredential(credentialid, _user.getUserid());

        if(n == null){
            attributes.addFlashAttribute("alertClass", "danger");
            attributes.addFlashAttribute("msg", "Credential not found.");
            return new RedirectView("/home");
        }
        attributes.addFlashAttribute("alertClass", "success");
        attributes.addFlashAttribute("msg", "Your credential for "+n.getUrl()+" has been deleted successfully");

        credentialsMapper.deleteCredential(n.getCredentialid(), _user.getUserid());

        return new RedirectView("/home");

    }


    @RequestMapping("/home")
    public ModelAndView getHome(@ModelAttribute("alertClass") String alertClass, @ModelAttribute("msg") String msg){

        ModelAndView mav = new ModelAndView();
        mav.setViewName("home");

        String _sessionUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        Users _user = usersMapper.getUserByUsername(_sessionUsername);

        if(_user == null){

            mav.addObject("msg", "Error on session ID.");
            mav.addObject("alertClass", "danger");
            return mav;

        }

        try{
            int maxKeyLen = Cipher.getMaxAllowedKeyLength("AES");
            System.out.println("MaxAllowedKeyLength=[" + maxKeyLen + "].");

        }catch (NoSuchAlgorithmException e){

        }


        es = new EncryptionService();

        /*String enripto = es.encryptValue("aqswdefr1234","" +
                "");

        System.out.println("Ecriptado es   "+enripto);*/

        ArrayList<Credentials> newCreds = new ArrayList<>();
        for(Credentials c : credentialsMapper.getCredentials()){
            c.setUnencripted(es.decryptValue(c.getPassword(),c.getKey()));
            newCreds.add(c);
        }



        mav.addObject("notes", notesMapper.getNotesByUserid(_user.getUserid()));
        mav.addObject("credentials", newCreds);
        mav.addObject("note", new Notes());
        mav.addObject("file", new Files());
        mav.addObject("credential", new Credentials());
        mav.addObject("msg", msg);
        mav.addObject("alertClass", alertClass);
        return mav;
    }




    @Autowired
    private FileStorageService dbFileStorageService;


    @PostMapping("/home/file/upload")
    public RedirectView file(@RequestParam("fileUpload") MultipartFile file,
                             RedirectAttributes redirectAttributes) {
        String _sessionUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        Users _user = usersMapper.getUserByUsername(_sessionUsername);

        Files f = dbFileStorageService.storeFile(file, _user.getUserid());

        return new RedirectView("/home");
    }
}
