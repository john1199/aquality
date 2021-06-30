package com.unal.aquality.controller;

import com.unal.aquality.controller.dto.UserDto;
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

    @PostMapping("/register")
    public String register(@ModelAttribute("user") UserDto userDto) throws Exception{
        String parametros = Error(userDto);
        if(parametros!=null){
            parametros = "alert&"+parametros;
            return "redirect:/register?"+parametros;
        }else{
            User user = userService.registerUser(userDto);
            if (user != null) {
                parametros= "success";
                return "redirect:/login?"+parametros;
            } else {
                parametros="error&EE";
                return "redirect:/register?"+parametros;
            }
        }
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password){
        boolean flag = false;
        User user = userService.userExist(email);
        if(user != null){
            flag = userService.decode(password, user.getPassword());
            if(flag){
                return "redirect:/home";
            }else{
                return "redirect:/login?password";
            }
        }else{
            return "redirect:/login?user";
        }
    }

    @PutMapping("/update")
    public String update(@ModelAttribute("user")UserDto userDto) throws Exception {
        User user = userService.updateUser(userDto);
        return user.get_id();
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
            if(serDto.getName().charAt(i)<65||serDto.getName().charAt(i)>184||(serDto.getName().charAt(i)<97&&serDto.getName().charAt(i)>90)||(serDto.getName().charAt(i)<127&&serDto.getName().charAt(i)>122)||(serDto.getName().charAt(i)<160&&serDto.getName().charAt(i)>154)){

                return "II&N";
            }
        }
        for(int i =0;i<serDto.getSurname().length();i++){
            if(serDto.getSurname().charAt(i)<65||serDto.getSurname().charAt(i)>122||(serDto.getSurname().charAt(i)<97&&serDto.getSurname().charAt(i)>90)){
                return "II&SN";
            }
        }

        if(serDto.getPassword().length()<6){
            return "L&P";
        }

        return null;
    }

}
