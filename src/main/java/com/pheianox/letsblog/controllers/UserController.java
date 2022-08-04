package com.pheianox.letsblog.controllers;

import com.pheianox.letsblog.entities.UserEntity;
import com.pheianox.letsblog.exceptions.UserAlreadyExistException;
import com.pheianox.letsblog.exceptions.UserNotFoundException;
import com.pheianox.letsblog.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
  @Autowired
  private final UserService userService;

  // Get All Users
  @GetMapping(path = "/users")
  public List<UserEntity> getAllUsers() {
    return userService.getAll();
  }

  // Get One User
  @GetMapping(path = "/users/{id}")
  public ResponseEntity getUser(@PathVariable String id) {
    try {
      return ResponseEntity.ok().body(userService.getOne(id));
    } catch (UserNotFoundException e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    } catch (Exception e) {
      return ResponseEntity.internalServerError().body("Something went wrong");
    }
  }

  // Create User
  @PostMapping(path = "/users")
  public ResponseEntity createUser(@RequestBody UserEntity user) {
    try {
      userService.create(user);
      return ResponseEntity.ok("User is created successfully");
    } catch (UserAlreadyExistException e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    } catch (Exception e) {
      return ResponseEntity.internalServerError().body("Something went wrong");
    }
  }

  // Delete User
  @DeleteMapping(path = "/users/{id}")
  public ResponseEntity deleteUser(@PathVariable String id) {
    try {
      userService.delete(id);
      return ResponseEntity.ok("User is deleted successfully");
    } catch (Exception e) {
      return ResponseEntity.internalServerError().body("Something went wrong");
    }
  }
}
