package com.example.mycompany.todoapplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Welcome {
    @RequestMapping(value = {"","/","/home"})
    public String welcomePage (){
        return "welcome";
    }

}
