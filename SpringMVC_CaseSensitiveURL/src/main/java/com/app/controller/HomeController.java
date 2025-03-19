package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/welcome")
    public String showHomePage1(){
        return "home";
    }

    @RequestMapping("/WELCOME")
    public String showHomePage2(){
        return "home2";
    }
}
