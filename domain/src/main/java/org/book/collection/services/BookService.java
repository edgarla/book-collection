package org.book.collection.services;

import java.util.List;
import org.book.collection.model.Book;

public interface BookService {

  Book findById(Long id);

  List<Book> findAll();

  Book save(Book book);
}
