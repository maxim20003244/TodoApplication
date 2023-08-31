package com.example.mycompany.todoapplication.controller;

import com.example.mycompany.todoapplication.model.Person;
import com.example.mycompany.todoapplication.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Slf4j
@RequestMapping("/public")
public class PublicController {
  private final PersonService personService;

    public PublicController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String displayRegisterPage(Model model){
        model.addAttribute("person" , new Person());
        return "create-user";
    }

    @RequestMapping(value = {"/createUser"}, method = RequestMethod.POST)
    public String createUser(@ModelAttribute("person")Person person, Errors errors){
        if(errors.hasErrors()){
            return "create-user";
        }
        boolean isSaved = personService.createNewPerson(person);
        if(isSaved){
            return "redirect:/login?register=true";
        }else {
            return "create-user";
        }

    }
}
