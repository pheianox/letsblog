package com.pheianox.letsblog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pheianox.letsblog.entities.UserEntity;
import com.pheianox.letsblog.exceptions.UserAlreadyExistException;
import com.pheianox.letsblog.exceptions.UserNotFoundException;
import com.pheianox.letsblog.services.UserService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class UserController {
  @Autowired
  private final UserService userService;

  @GetMapping(path = "/users")
  public List<UserEntity> getAllUsers() {
    System.out.println("getAll() ");
    return userService.getAll();
  }

  @GetMapping(path = "/users/{id}")
  public ResponseEntity getOneUser(@PathVariable String id) {
    try {
      System.out.println("getOneUser() id = " + id);
      return ResponseEntity.ok().body(userService.getOne(id));
    } catch (UserNotFoundException e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("Something went wrong");
    }
  }

  @PostMapping(path = "/users")
  public ResponseEntity createUser(@RequestBody UserEntity user) {
    try {
      userService.create(user);
      return ResponseEntity.ok("User is created successfully");
    } catch (UserAlreadyExistException e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("Something went wrong");
    }
  }

  @DeleteMapping(path = "/users/{id}")
  public ResponseEntity deleteUser(@PathVariable String id) {
    try {
      userService.delete(id);
      return ResponseEntity.ok("User is deleted successfully");
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("Something went wrong");
    }
  }
}
