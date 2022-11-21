package org.book.collection.entities;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Document(collection = "books")
public record Books(@Id Long id, String name) {
  @Transient
  public static final String SEQUENCE_NAME = "books_sequence";
}
