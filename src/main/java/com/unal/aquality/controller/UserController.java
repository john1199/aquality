package com.unal.aquality.controller;

import com.unal.aquality.model.User;
import com.unal.aquality.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/register")
    public String viewRegister(){
        return "register";
    }
    @PostMapping("/register")
    public String register(@ModelAttribute("user")UserDto userDto) throws Exception{
        User user = userService.registerUser(userDto);
        if(user!=null){
            return "redirect:/register?success";
        }else{
            return "redirect:/register?error";
        }
    }

    @ModelAttribute("user")
    public UserDto userDto(){
        return new UserDto();
    }
}
