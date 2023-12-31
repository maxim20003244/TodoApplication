package com.example.mycompany.todoapplication.controller;

import com.example.mycompany.todoapplication.model.Person;
import com.example.mycompany.todoapplication.service.PersonService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class LoginController {

    @RequestMapping(value = {"/login"}, method = {RequestMethod.POST, RequestMethod.GET})
    public String displayLoginPage(@RequestParam(value = "error", required = false) String error,
                                   @RequestParam(value = "logout", required = false)String logout,
                                   @RequestParam(value = "register" , required = false) String register,
                                   Model model){
      String errorMessages = null;

      if(error!=null){
          errorMessages = "Username or password is incorrect!";
      }
     else if (logout != null) {
        errorMessages = "You have been successfully logged out !!";
    }
      else if (register != null) {
          errorMessages = "You registration successful. Login with registered credentials !!";
      }
      model.addAttribute("errorMessages", errorMessages);
    return "login.html";

}
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout=true";
    }
}
