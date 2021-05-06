package com.unal.aquality.service;

import com.unal.aquality.model.User;
import com.unal.aquality.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;


    @Override
    public User getUser(ObjectId userId){
        try{
            return userRepository.findBy_id(userId);
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public User registerUser(User user) throws Exception {
        if(userRepository.findByemail(user.getEmail()) == null){
            user.setId(ObjectId.get());
            user.setPassword(encode(user.getEmail()));
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
    public boolean decode(String password,String encodedPassword) throws Exception{
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder.matches(password, encodedPassword);
    }

}
