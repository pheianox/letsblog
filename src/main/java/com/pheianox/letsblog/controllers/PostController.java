package com.pheianox.letsblog.controllers;

import java.util.List;

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

import com.pheianox.letsblog.entities.PostEntity;
import com.pheianox.letsblog.services.PostService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostController {
  @Autowired
  private final PostService postService;

  // Get All Posts
  @GetMapping(path = "/posts")
  public List<PostEntity> getAllPosts() {
    return postService.getAll();
  }

  // Create Post
  @PostMapping(path = "/posts")
  public ResponseEntity createPost(@RequestBody PostEntity post) {
    try {
      postService.create(post);
      return ResponseEntity.ok("Post created successfully");
    } catch (Exception e) {
      return ResponseEntity.internalServerError().body("Something went wrong");
    }
  }

  // Delete Post
  @DeleteMapping(path = "/posts/{id}")
  public ResponseEntity deletePost(@PathVariable String id) {
    try {
      postService.delete(id);
      return ResponseEntity.ok("User is deleted successfully");
    } catch (Exception e) {
      return ResponseEntity.internalServerError().body("Something went wrong");
    }
  }
}
