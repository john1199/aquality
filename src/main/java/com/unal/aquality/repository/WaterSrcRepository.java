package com.unal.aquality.repository;

import com.unal.aquality.model.FuenteHidrica;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WaterSrcRepository extends MongoRepository<FuenteHidrica, String> {

    List<FuenteHidrica> findAll();
    FuenteHidrica findBy_id(ObjectId userId);
    FuenteHidrica findByname(String name);
    void deleteBy_id(ObjectId userId);
}