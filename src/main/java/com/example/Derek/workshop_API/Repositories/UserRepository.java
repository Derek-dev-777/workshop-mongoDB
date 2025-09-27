package com.example.Derek.workshop_API.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.Derek.workshop_API.Models.Entities.UserEntity;

@Repository
public interface UserRepository extends MongoRepository<UserEntity, String>{

}
