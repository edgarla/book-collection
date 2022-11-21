package org.book.collection.util;

import lombok.NonNull;
import org.book.collection.entities.Books;
import org.book.collection.model.Book;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BookModelConverter implements Converter<Books, Book> {

  @NonNull
  @Override
  public Book convert(Books source) {
    return new Book(source.id(), source.name());
  }
}
