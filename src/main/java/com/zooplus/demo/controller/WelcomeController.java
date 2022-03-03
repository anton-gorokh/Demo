package com.zooplus.demo.controller;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class WelcomeController {
    @GetMapping("/")
    public ModelAndView welcome() {
        return new ModelAndView("index");
    }
}
