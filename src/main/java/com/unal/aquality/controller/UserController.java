package com.unal.aquality.controller;

import com.unal.aquality.model.User;
import com.unal.aquality.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/signin")
    public String login(@RequestParam String email, @RequestParam String password){
        boolean flag = false;
        User user = userService.userExist(email);
        if(user != null){
            flag = userService.decode(password, user.getPassword());
            if(flag){
                return "redirect:/register?success";
            }else{
                return "redirect:/register?password";
            }
        }else{
            return "redirect:/register?user";
        }
    }
    @PutMapping("/update")
    public String update(@ModelAttribute("user")UserDto userDto) throws Exception {
        User user = userService.updateUser(userDto);
        return user.get_id();
    }
    @GetMapping("/")
    public String ss(@ModelAttribute UserDto userDto) throws Exception {
        return "prueba";
    }
    @ModelAttribute("user")
    public UserDto userDto(){
        return new UserDto();
    }
}
