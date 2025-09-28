package com.example.Derek.workshop_API.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.Derek.workshop_API.Models.Entities.PostEntity;

@Repository
public interface PostRepository extends MongoRepository<PostEntity, String>{

}
