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
    public String update(@ModelAttribute UserDto userDto) throws Exception {
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
            if(serDto.getName().charAt(i)<65||serDto.getName().charAt(i)>122||(serDto.getName().charAt(i)<97&&serDto.getName().charAt(i)>90)){
                
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
