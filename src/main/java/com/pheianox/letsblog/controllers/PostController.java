package com.pheianox.letsblog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pheianox.letsblog.entities.PostEntity;
import com.pheianox.letsblog.services.PostService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class PostController {
  @Autowired
  private final PostService postService;

  @GetMapping(path = "/posts")
  public List<PostEntity> getAllPosts() {
    return postService.getAll();
  }

  @GetMapping(path = "/post/{id}")
  public ResponseEntity getPost(@PathVariable String id) {
    try {
      return ResponseEntity.ok(postService.getOne(id));
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("Something went wrong");
    }
  }
}
