package com.pheianox.letsblog.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pheianox.letsblog.entities.UserEntity;
import com.pheianox.letsblog.exceptions.UserAlreadyExistException;
import com.pheianox.letsblog.services.UserService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/users")
public class UserController {
  private final UserService userService;

  @GetMapping
  public List<UserEntity> fetchAllUsers() {
    return userService.getAllUsers();
  }

  @PostMapping
  public ResponseEntity<String> createUser(@RequestBody UserEntity user) {
    try {
      userService.addUser(user);
      return ResponseEntity.ok("User is created successfully");
    } catch (UserAlreadyExistException e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("Something went wrong");
    }
  }

  // @RequestMapping(method = RequestMethod.POST)
  // public void createNewUser(@RequestBody Map<String, Object> body) {
  // return userService.createUser(body.name, body.email);
  // }
}
