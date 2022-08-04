package com.pheianox.letsblog.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pheianox.letsblog.entities.UserEntity;
import com.pheianox.letsblog.exceptions.UserAlreadyExistException;
import com.pheianox.letsblog.exceptions.UserNotFoundException;
import com.pheianox.letsblog.repositories.UserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserService {
  private final UserRepository userRepository;

  public List<UserEntity> getAll() {
    return userRepository.findAll();
  }

  public UserEntity getOne(String id) throws UserNotFoundException {
    Optional<UserEntity> user = userRepository.findById(id);
    if (user.isEmpty()) {
      throw new UserNotFoundException("User with id \"" + id + "\" not found");
    }
    return user.get();
  }

  public UserEntity create(UserEntity user) throws UserAlreadyExistException {
    if (!userRepository.findByEmail(user.getEmail()).isEmpty()) {
      throw new UserAlreadyExistException("User already exist");
    }
    return userRepository.save(user);
  }

  public String delete(String id) {
    userRepository.deleteById(id);
    return id;
  }
}
