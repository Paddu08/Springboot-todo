package com.example.springboottodolist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import com.example.springboottodolist.services.TodoItemService;

@Controller
public class HomeController {
    @Autowired
    private TodoItemService todoitemservice;

    @GetMapping("/")
    public ModelAndView index(){
        ModelAndView modelAndView=new ModelAndView("index");
        modelAndView.addObject("todoItems",todoitemservice.getAll());
        return modelAndView;

    }

}
