package org.book.collection.repositories;

import org.book.collection.entities.Books;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataMongoBookRepository extends MongoRepository<Books, Long> {
}
