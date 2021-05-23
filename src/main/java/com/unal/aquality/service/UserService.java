package com.unal.aquality.service;

import com.unal.aquality.controller.UserDto;
import com.unal.aquality.model.User;
import org.bson.types.ObjectId;

public interface UserService {
    User registerUser(UserDto user) throws Exception;
    User getUser(ObjectId userId);
    User userExist(String email);
    User updateUser(User user) throws Exception;
    ObjectId deleteUser(ObjectId userId);
    boolean decode(String password,String encodedPassword);
}
