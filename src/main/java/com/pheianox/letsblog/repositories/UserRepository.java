package com.pheianox.letsblog.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pheianox.letsblog.entities.UserEntity;

public interface UserRepository extends MongoRepository<UserEntity, String> {
  List<UserEntity> findByEmail(String email);
}
