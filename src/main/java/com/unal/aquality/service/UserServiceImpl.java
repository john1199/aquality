package com.unal.aquality.service;

import com.unal.aquality.model.User;
import com.unal.aquality.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;


    @Override
    public User getUser(ObjectId userId) throws Exception {
        if(userId==null){
            throw new Exception();
        }
        try{

            return userRepository.findBy_id(userId);
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public User registerUser(User user) throws Exception {
        HashMap<String,ArrayList<String>> errors = user.Error();
        if(!errors.isEmpty()){
            throw new Exception(errors.toString());
        }

        if(userRepository.findByemail(user.getEmail()) == null){
            user.setId(ObjectId.get());
            user = userRepository.save(user);


            return user;
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
    public ObjectId deleteUser(ObjectId userId) throws Exception {
        if (getUser(userId) == null) {
            return null;
        } else {
            userRepository.deleteBy_id(userId);
            return userId;
        }
    }

}
