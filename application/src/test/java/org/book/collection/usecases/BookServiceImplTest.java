package org.book.collection.usecases;

import java.util.Collections;
import org.book.collection.gateways.BookGateway;
import org.book.collection.services.BookServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest(classes = {BookServiceImpl.class})
class BookServiceImplTest {

  @MockBean
  private BookGateway bookGateway;

  @InjectMocks
  private BookServiceImpl bookService;

  @BeforeEach
  void init() {
    Mockito.when(bookGateway.findAll()).thenReturn(Collections.emptyList());
  }

  @Test
  void contextLoad() {
    Assertions.assertNotNull(bookService);
  }
}
