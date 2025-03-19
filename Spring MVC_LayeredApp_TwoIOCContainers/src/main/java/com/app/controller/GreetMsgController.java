package com.app.controller;

import com.app.service.GreetMsgService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class GreetMsgController implements Controller {

    private GreetMsgService msgService;

    public GreetMsgController(GreetMsgService msgService) {
        this.msgService = msgService;
    }



    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String msg = msgService.generateGreetMsg();
        ModelAndView modelAndView = new ModelAndView("result","greetMsg",msg);
        return modelAndView;
    }
}
