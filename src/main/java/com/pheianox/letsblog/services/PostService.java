package com.pheianox.letsblog.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pheianox.letsblog.entities.PostEntity;
import com.pheianox.letsblog.repositories.PostRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PostService {
  private final PostRepository postRepository;

  public List<PostEntity> getAll() {
    return postRepository.findAll();
  }

  public PostEntity create(PostEntity post) {
    post.setDate(System.currentTimeMillis());
    return postRepository.save(post);
  }

  public String delete(String id) {
    postRepository.deleteById(id);
    return id;
  }
}
