package com.app.controller;

import com.app.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class StudentController {

    @GetMapping("/student")
    public String showStudentRegistrationPage(@ModelAttribute("student") Student stu) {
        stu.setName("Amit Kumar Verma");
        return "student_registration_page";
    }

    @PostMapping("/student")
    public String registerStudent(Map<String, Object> map, @ModelAttribute("student") Student stu){

        System.out.println(stu);

        map.put("studentFormData", stu );

        return "result";

    }
}
