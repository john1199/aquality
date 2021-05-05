package com.unal.aquality.controller;

import com.unal.aquality.model.User;
import com.unal.aquality.repository.UserRepository;
import com.unal.aquality.service.UserService;
import com.unal.aquality.service.UserServiceImpl;
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

    @GetMapping("")
    public String view() {
        return "register";
    }

    @GetMapping("/{id}")
    public ResponseEntity getUser(@PathVariable ObjectId id) throws Exception {
        HashMap<String, Object> res = new HashMap<>();
        User user = userService.getUser(id);
        if(user == null){
            res.put("msg", "get user unsuccessfully");
        }else{
            res.put("user", user);
            res.put("msg", "get user successfully");
        }
        return new ResponseEntity(res, HttpStatus.OK);
    }

    //POST
    @PostMapping("/add")
    public ResponseEntity saveUser(@RequestBody User user) throws Exception {
        HashMap<String, Object> res = new HashMap<>();
        User userDB = userService.registerUser(user);
        if (userDB == null){
            res.put("msg", "user exists, cannot be added");
        }else{
            res.put("user", user);
            res.put("msg", "Successfully add");
        }
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    //DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable String id) throws Exception {
        HashMap<String, Object> res = new HashMap<>();
        userService.deleteUser(id);
        res.put("msg", "Successfully add");
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
