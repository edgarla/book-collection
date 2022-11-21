package org.book.collection.util;

import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.book.collection.entities.Books;
import org.book.collection.model.Book;
import org.book.collection.util.service.SequenceService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookEntityConverter implements Converter<Book, Books> {

  private final SequenceService sequenceService;

  @Override
  public Books convert(Book source) {
    return Books.builder()
            .id(Objects.isNull(source.id()) ? sequenceService.getNextSequenceId(Books.SEQUENCE_NAME) : source.id())
            .name(source.name())
            .build();
  }
}
