package com.pheianox.letsblog.entities;

import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class UserEntity {
  @Id
  private String id;
  private String name;
  @Indexed
  private String email;

  public UserEntity(String name, String email) {
    this.name = name;
    this.email = email;
  }
}
