package org.book.collection.rest;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.book.collection.model.Book;
import org.book.collection.requests.AddBookRequest;
import org.book.collection.services.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/books")
public class BookController {

  private final BookService bookService;

  @GetMapping(value = "/{id}", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
  public ResponseEntity<Book> getBookById(@PathVariable final long id) {
    return ResponseEntity.ok(bookService.findById(id));
  }

  @GetMapping(value = "/all")
  public ResponseEntity<List<Book>> getAllBooks() {
    return ResponseEntity.ok(bookService.findAll());
  }

  @PostMapping(value = "/add", consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
  public ResponseEntity<Book> addBook(@RequestBody final AddBookRequest request) {
    return ResponseEntity.ok(bookService.save(new Book(null, request.name())));
  }
}
