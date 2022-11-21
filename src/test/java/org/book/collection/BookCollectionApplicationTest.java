package org.book.collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookCollectionApplicationTest {
  @Test
  void contextLoad() {
    BookCollectionApplication bookCollectionApplication = new BookCollectionApplication();
    Assertions.assertNotNull(bookCollectionApplication);
  }
}
