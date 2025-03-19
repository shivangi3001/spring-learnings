package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

//    @RequestMapping("/welcome")
//    public String showHomePage(){
//        return "home";
//    }


//    @RequestMapping
    @RequestMapping("/")
    public String showDefaultHomePage(){
        return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String showDefaultHomePage2(){
       return "home";
    }

    //by default - GET METHOD
    @RequestMapping("/register")
    public String saveStudentData(){
        return "result";
    }

    /*
    // explicitly mentioned - POST method
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String saveStudentData2(){
        return "result2";
    }

    */


    @RequestMapping(value = {"/home", "/welcome", "/manish"})
    public String showHomePage2(){
        return "home";
    }


    @RequestMapping(value = "/register", method={RequestMethod.GET, RequestMethod.POST})
    public String registerStudentData(){
        System.out.println("get post both method mode handler method working");
        return "result2";
    }
}
