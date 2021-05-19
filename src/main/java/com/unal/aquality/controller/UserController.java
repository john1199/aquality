package com.unal.aquality.controller;


import com.unal.aquality.model.User;
import com.unal.aquality.repository.UserRepository;
import com.unal.aquality.service.UserService;
import com.unal.aquality.service.UserServiceImpl;
import javafx.beans.binding.ObjectExpression;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    //GET
    @GetMapping("/{id}")
    public ResponseEntity getUser(@PathVariable ObjectId id) throws Exception {

        HashMap<String, Object> res = new HashMap<>();
        HttpStatus state = HttpStatus.OK;
        try{
            User user = userService.getUser(id);
            if(user == null){
                res.put("msg", "user does not exist");
            }else{
                res.put("user", user);
                res.put("msg", "get user successfully");
            }
        }catch(Exception e){
            res.put("msg",e.getMessage());
            state=HttpStatus.NOT_ACCEPTABLE;
        }

        return new ResponseEntity(res, state);
    }

    //POST
    @PostMapping("/add")
    public ResponseEntity saveUser(@RequestBody User user) throws Exception {
        HashMap<String, Object> res = new HashMap<>();

        HttpStatus state = HttpStatus.OK;
        try{
            User userDB = userService.registerUser(user);
            if (userDB == null){
                res.put("msg", "cannot be added");
            }else{
                res.put("user", user);
                res.put("msg", "Successfully add");
            }
        }catch(Exception e){
            String mess =e.getMessage();
            res.put("msg",mess);
            if(mess.substring(1,mess.indexOf('=')).equals("null")){
                state=HttpStatus.NOT_ACCEPTABLE;
            }else if(mess.substring(1,mess.indexOf('=')).equals("gram")){
                state=HttpStatus.BAD_GATEWAY;
            }
        }


        return new ResponseEntity<>(res, state);
    }


    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@RequestBody ObjectId id){
        HashMap<String, Object> res = new HashMap<>();
        HttpStatus state = HttpStatus.OK;
        try{
            ObjectId _id = userService.deleteUser(id);
            if (_id == null){
                res.put("msg", "user id is null or user no exist");
            }else{
                res.put("msg", "Successfully delete user "+ _id.toHexString());
            }
        }catch(Exception e){
            res.put("msg",e.getMessage());
            state=HttpStatus.NOT_ACCEPTABLE;
        }

        return new ResponseEntity(res, state);
    }


}
