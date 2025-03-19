package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @RequestMapping("/homepage")
    public String showHomePage(){
        return "home";
    }

    /*
    @RequestMapping(value = "/register-student")
    public String saveStudentData() {
        return "result";
    }
    */

    @RequestMapping(value = "/register-student")
    public String saveStudentData() {
        return "redirect:/student/register";
    }


}
