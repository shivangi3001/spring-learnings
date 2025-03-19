package com.app.controller;

import com.app.dto.StudentDto;
import com.app.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
public class StudentController {

    @Autowired
    private StudentService service;

    @RequestMapping("/welcome")
    public String showHomePage() {
        return "home";
    }

    @RequestMapping("/get-all-students")
    public String showAllStudents(Map<String, Object> map){
        //use the service
        List<StudentDto> dtoList = service.getAllStudentList();
        map.put("studentDtoList", dtoList);
        return "student_list";
    }

}
