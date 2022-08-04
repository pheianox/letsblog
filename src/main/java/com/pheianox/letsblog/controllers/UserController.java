package com.pheianox.letsblog.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pheianox.letsblog.models.User;
import com.pheianox.letsblog.services.UserService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/users")
public class UserController {
  private final UserService userService;

  @GetMapping()
  public List<User> fetchAllUsers() {
    return userService.getAllUsers();
  }

  // @RequestMapping(method = RequestMethod.POST)
  // public void createNewUser(@RequestBody Map<String, Object> body) {
  // return userService.createUser(body.name, body.email);
  // }
}
