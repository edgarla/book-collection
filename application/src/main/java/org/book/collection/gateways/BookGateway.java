package org.book.collection.gateways;

import java.util.List;
import org.book.collection.model.Book;

public interface BookGateway {

  Book findById(Long id);

  List<Book> findAll();

  Book save(Book book);
}
