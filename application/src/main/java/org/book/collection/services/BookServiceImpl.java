package org.book.collection.services;

import java.util.List;
import org.book.collection.model.Book;
import org.book.collection.gateways.BookGateway;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

  private final BookGateway bookGateway;

  public BookServiceImpl(BookGateway bookGateway) {
    this.bookGateway = bookGateway;
  }

  @Override
  public Book findById(Long id) {
    return bookGateway.findById(id);
  }

  @Override
  public List<Book> findAll() {
    return bookGateway.findAll();
  }

  @Override
  public Book save(Book book) {
    return bookGateway.save(book);
  }
}
