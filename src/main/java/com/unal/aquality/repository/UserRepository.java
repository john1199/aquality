package com.unal.aquality.repository;

import com.unal.aquality.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    User findBy_id(ObjectId userId);
    User findByemail(String email);
}
