package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Controller
public class TestController {
    @GetMapping(value = "/time")
    public ModelAndView time() {
        ModelAndView model = new ModelAndView("/time");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedTime = LocalTime.now().format(formatter);
        model.addObject("time", formattedTime);
        return model;
    }

    @GetMapping(value = "/test")
    public ModelAndView test()
    {
        ModelAndView model = new ModelAndView("/test");
        return model;
    }

}
