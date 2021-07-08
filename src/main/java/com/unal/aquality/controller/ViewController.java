package com.unal.aquality.controller;

import com.unal.aquality.controller.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ViewController {

    @GetMapping("/")
    public String viewHome(){
        return "HomePage/index";
    }

    @GetMapping("/login")
    public String viewLogin(){
        return "login";
    }

    @GetMapping("/register")
    public String viewRegister(){
        return "register";
    }


    @GetMapping("/mapa")
    public String mapa(){
        return "HomePage/mapa";
    }

    @GetMapping("/sistema")
    public String sistema(){
        return "HomePage/sistema";
    }

    @GetMapping("/historico")
    public String historico(){
        return "HomePage/historico";
    }


    @GetMapping("/list")
    public String list(){
        return "list";
    }

    @GetMapping("/adminWaterSrc")
    public String adminWaterSrc(){
        return "adminWaterSrc";
    }

    @GetMapping("/watersource/registerWaterSrc")
    public String viewRegisterWaterSrc(){
        return "registerWaterSrc";
    }

    @ModelAttribute("user")
    public UserDto userDto(){
        return new UserDto();
    }

}
