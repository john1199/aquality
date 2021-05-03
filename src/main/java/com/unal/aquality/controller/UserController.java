package com.unal.aquality.controller;

import com.unal.aquality.model.User;
import com.unal.aquality.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {
    @Autowired
    private UserRepository repository;
    //POST
    @PostMapping("/addUser")
    public String saveUser(@RequestBody User user) {
        /*/*/
        repository.save(user);
        /*return "Added book with id : " + user.getId();*/
        return  "Added user successfully";
    }

    //GET
    @GetMapping("/user/{id}")
    public Optional<User> getUser(@PathVariable int id) {
        return repository.findById(id);
    }

    @GetMapping("/")
    public String view() {
        return "login";
    }
    @GetMapping("/user")
    public String view2() {
        return "login";
    }

    //DELETE
    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        repository.deleteById(id);
        return "book deleted with id : " + id;
    }
}
