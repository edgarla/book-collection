package org.book.collection.util.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "documents_sequences")
public record DatabaseSequence(@Id String id, Long sequence) {
}
