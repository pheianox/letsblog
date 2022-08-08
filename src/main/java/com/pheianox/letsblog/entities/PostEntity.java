package com.pheianox.letsblog.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "posts")
public class PostEntity {
  @Id
  private String id;
  private String title;
  private String content;
  private Integer date;
  private String author;
}
