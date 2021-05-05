package com.unal.aquality.service;

import com.unal.aquality.model.User;
import com.unal.aquality.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public User getUser(ObjectId userId) throws Exception {
        return userRepository.findBy_id(userId);
    }

    @Override
    public User registerUser(User user) throws Exception {
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
    public void deleteUser(String userId) throws Exception {
        if (userId == null) {
            throw new Exception("user id is null");
        } else {
            userRepository.deleteById(userId);
        }
    }
}
