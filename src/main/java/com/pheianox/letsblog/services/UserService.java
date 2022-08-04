package com.pheianox.letsblog.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pheianox.letsblog.entities.UserEntity;
import com.pheianox.letsblog.exceptions.UserAlreadyExistException;
import com.pheianox.letsblog.repositories.UserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserService {
  private final UserRepository userRepository;

  public List<UserEntity> getAllUsers() {
    return userRepository.findAll();
  }

  public Optional<UserEntity> getById(String id) {
    return userRepository.findById(id);
  }

  public UserEntity addUser(UserEntity user) throws UserAlreadyExistException {
    if (!userRepository.findByEmail(user.getEmail()).isEmpty()) {
      throw new UserAlreadyExistException("User already exist");
    }
    return userRepository.save(user);
  }
}
