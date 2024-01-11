package com.bitlord.springboottodoapp.controllers;

import com.bitlord.springboottodoapp.services.TodoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @Autowired
    private TodoItemService todoItemService;

    // firstly loaded  method
    @GetMapping("/")
    public ModelAndView index(){

        ModelAndView modelAndView = new ModelAndView("index"); // index file
        modelAndView.addObject( "todoItems", todoItemService.getAll() );
        return modelAndView;
    }

}
