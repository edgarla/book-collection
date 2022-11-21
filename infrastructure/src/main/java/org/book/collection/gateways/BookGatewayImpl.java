package org.book.collection.gateways;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.book.collection.model.Book;
import org.book.collection.repositories.SpringDataMongoBookRepository;
import org.book.collection.util.BookModelConverter;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookGatewayImpl implements BookGateway {

  private final SpringDataMongoBookRepository springDataMongoBookRepository;
  private final BookModelConverter bookModelConverter;
  @Override
  public Book findById(Long id) {
    return bookModelConverter.convert(springDataMongoBookRepository.findById(id).orElseThrow());
  }

  @Override
  public List<Book> findAll() {
    return springDataMongoBookRepository.findAll().stream()
            .map(bookModelConverter::convert)
            .toList();
  }

  @Override
  public Book save(Book book) {
    return null;
  }
}
