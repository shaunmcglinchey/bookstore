package com.example.repositories;

import com.example.beans.Policy;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface PolicyDao extends MongoRepository<Policy, ObjectId> {

    List<Policy> findByCustomerId(ObjectId customerId);

}