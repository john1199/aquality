package com.unal.aquality.service;

import com.unal.aquality.controller.dto.UserDto;
import com.unal.aquality.model.Rol;
import com.unal.aquality.model.User;
import com.unal.aquality.repository.UserRepository;
import org.bson.types.ObjectId;;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

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
    @Override
    public List<User> userList(){
        try{
            return userRepository.findAll();
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
        if(userRepository.findByemail(userDto.getEmail()) == null && userRepository.findByusername(userDto.getUsername()) ==null){
            if(userDto.getRol() == null){
                userDto.setRol(Rol.LOCAL);
            }else {
                userDto.setRol(Rol.ADMIN);
            }
            User user = new User(userDto.getDocument(), userDto.getName(),userDto.getSurname(), userDto.getUsername(),userDto.getEmail(),userDto.getRol(),encode(userDto.getPassword()));
            return userRepository.save(user);
        }else{
            return null;
        }
    }

    @Override
    public User updateUser(UserDto userDto) throws Exception {
        User user = userRepository.findBy_id(userDto.get_id());
        if(user == null){
            user.setName(userDto.getName());
            user.setSurname(userDto.getSurname());
            user.setEmail(userDto.getEmail());
            user.setRol(userDto.getRol());
            user.setPassword(encode(userDto.getPassword()));
            userRepository.save(user);
            return user;
        }else {
            return null;
        }
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
