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
        String parametros = Error(userDto);
        if(parametros!=null){
            parametros = "alert&"+parametros;
        }else{
            User user = userService.registerUser(userDto);
            if (user != null) {
                parametros= "success";
            } else {
                parametros="error&EE";
            }
        }

        return "redirect:/register?"+parametros;
    }

    @ModelAttribute("user")
    public UserDto userDto(){
        return new UserDto();
    }

    private String Error(UserDto serDto){
        if(serDto.getName()==null||serDto.getName().equals("")){
            return "Empty&N";
        }
        if(serDto.getUsername()==null||serDto.getUsername().equals("")){
            return "Empty&UN";
        }

        if(serDto.getSurname()==null||serDto.getSurname().equals("")){
            return "empty_SN";
        }

        if(serDto.getEmail()==null||serDto.getUsername().equals("")){
            return "Empty&E";
        }
        if(serDto.getPassword()==null||serDto.getPassword().equals("")){
            return "Empty&P";
        }

        //65 90 97 122
        for(int i =0;i<serDto.getName().length();i++){
            if(serDto.getName().charAt(i)<65||serDto.getName().charAt(i)>122||(serDto.getName().charAt(i)<97||serDto.getName().charAt(i)>90)){
                return "II&N";
            }
        }
        for(int i =0;i<serDto.getSurname().length();i++){
            if(serDto.getSurname().charAt(i)<65||serDto.getSurname().charAt(i)>122||(serDto.getSurname().charAt(i)<97||serDto.getSurname().charAt(i)>90)){
                return "II&SN";
            }
        }

        if(serDto.getPassword().length()<6){
            return "L&P";
        }

        return null;
    }
}
