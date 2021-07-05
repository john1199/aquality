package com.unal.aquality.repository;

import com.unal.aquality.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    User findBy_id(ObjectId userId);
    User findByemail(String email);
    User findByusername(String username);
    void deleteBy_id(ObjectId userId);
}
