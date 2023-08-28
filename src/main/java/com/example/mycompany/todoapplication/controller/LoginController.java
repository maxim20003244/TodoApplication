package com.example.mycompany.todoapplication.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class LoginController {
@RequestMapping(value = {"/login"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String displayLoginPage(@RequestParam(value = "error", required = false) String error,
                                   @RequestParam(value = "logout", required = false)String logout, Model model){
      String errorMessages = null;

      if(error!=null){
          errorMessages = "Username or password is incorrect!";
      }
      model.addAttribute("errorMessages", errorMessages);
    return "login";

}
}
