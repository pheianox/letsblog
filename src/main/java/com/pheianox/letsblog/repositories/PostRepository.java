package com.pheianox.letsblog.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pheianox.letsblog.entities.PostEntity;

public interface PostRepository extends MongoRepository<PostEntity, String> {
}
