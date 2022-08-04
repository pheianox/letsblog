package com.pheianox.letsblog.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pheianox.letsblog.models.User;

public interface UserRepository extends MongoRepository<User, String> {
  List<User> findByEmail(String email);
}
