package com.pheianox.letsblog.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pheianox.letsblog.entities.PostEntity;
import com.pheianox.letsblog.exceptions.PostNotFoundException;
import com.pheianox.letsblog.repositories.PostRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PostService {
  private final PostRepository postRepository;

  public List<PostEntity> getAll() {
    return postRepository.findAll();
  }

  public PostEntity getOne(String id) throws PostNotFoundException {
    Optional<PostEntity> post = postRepository.findById(id);
    if (post.isEmpty()) {
      throw new PostNotFoundException("Post with id \"" + id + "\" not found");
    }
    return post.get();
  }

  public PostEntity create(PostEntity post) {
    // validation
    return postRepository.save(post);
  }

  public String delete(String id) {
    postRepository.deleteById(id);
    return id;
  }
}
