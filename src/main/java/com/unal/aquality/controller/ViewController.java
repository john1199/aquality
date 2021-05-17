package com.unal.aquality.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ViewController {

    @GetMapping("register")
    public String register(){
        return "register";
    }
    /*
    @GetMapping("login")
    public String login(){
        return "login";
    }

    @GetMapping("")
    public String index(){
        return "index";
    }
    */
}
