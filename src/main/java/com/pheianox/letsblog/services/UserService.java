package com.pheianox.letsblog.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pheianox.letsblog.models.User;
import com.pheianox.letsblog.repositories.UserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserService {
  private final UserRepository userRepository;

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  public Optional<User> getById(String id) {
    return userRepository.findById(id);
  }

  public boolean createUser(String email, String name) {
    if (userRepository.findByEmail(email).isEmpty()) {
      userRepository.insert(new User(name, email));
      return true;
    }
    return false;
  }
}
