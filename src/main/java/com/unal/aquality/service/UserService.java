package com.unal.aquality.service;

import com.unal.aquality.controller.dto.UserDto;
import com.unal.aquality.model.User;
import org.bson.types.ObjectId;

public interface UserService {
    User registerUser(UserDto userDto) throws Exception;
    User getUser(ObjectId userId);
    User userExist(String email);
    User updateUser(UserDto userDto) throws Exception;
    ObjectId deleteUser(ObjectId userId);
    boolean decode(String password,String encodedPassword);
}