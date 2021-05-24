package com.unal.aquality.service;

import com.unal.aquality.controller.UserDto;
import com.unal.aquality.model.User;
import com.unal.aquality.repository.UserRepository;
import org.bson.types.ObjectId;;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository){
        super();
        this.userRepository = userRepository;
    }

    @Override
    public User getUser(ObjectId userId){
        try{
            return userRepository.findBy_id(userId);
        }catch (Exception e){
            return null;
        }
    }
    public User userExist(String email){
        try{
            return userRepository.findByemail(email);
        }catch (Exception e){
            return null;
        }
    }
    @Override
    public User registerUser(UserDto userDto) throws Exception{
        if(userRepository.findByemail(userDto.getEmail()) == null){
            User user = new User(userDto.getName(),userDto.getSurname(), userDto.getUsername(),userDto.getEmail(),userDto.getRol(),encode(userDto.getPassword()));
            return userRepository.save(user);
        }else{
            return null;
        }
    }

    @Override
    public User updateUser(User user) throws Exception {
        user = userRepository.save(user);
        return user;
    }
    @Override
    public ObjectId deleteUser(ObjectId userId){
        if (getUser(userId) == null) {
            return null;
        } else {
            userRepository.deleteBy_id(userId);
            return userId;
        }
    }
    public String encode(String password) throws Exception{
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String hashedPass1 = bCryptPasswordEncoder.encode(password);
        return hashedPass1;
    }
    public boolean decode(String password,String encodedPassword){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder.matches(password, encodedPassword);
    }

}
