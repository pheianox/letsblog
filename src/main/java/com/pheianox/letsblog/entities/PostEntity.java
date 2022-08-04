package com.pheianox.letsblog.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class PostEntity {
  @Id
  private String id;
  private String title;
  private String content;
  private String authorId;
  private Integer createdAt;
}
