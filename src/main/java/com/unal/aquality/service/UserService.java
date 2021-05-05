package com.unal.aquality.service;

import com.unal.aquality.model.User;
import org.bson.types.ObjectId;

public interface UserService {
    User registerUser(User user) throws Exception;
    User getUser(ObjectId userId) throws Exception;
    User updateUser(User user) throws Exception;
    void deleteUser(String userId) throws Exception;
}
