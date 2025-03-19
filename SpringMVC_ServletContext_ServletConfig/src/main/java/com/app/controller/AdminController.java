package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping("/register")
    public String registerAdmin(){
        return "admin_registration";
    }
}
