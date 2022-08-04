package com.pheianox.letsblog.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class User {
  private String name;
  @Indexed
  private String email;
  @Id
  private String id;

  public User(String name, String email) {
    this.name = name;
    this.email = email;
  }
}
