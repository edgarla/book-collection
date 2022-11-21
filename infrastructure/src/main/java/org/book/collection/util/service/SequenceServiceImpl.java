package org.book.collection.util.service;

import java.util.Objects;
import org.book.collection.util.model.DatabaseSequence;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Service
public class SequenceServiceImpl implements SequenceService {

  private final MongoOperations mongoOperations;

  public SequenceServiceImpl(MongoOperations mongoOperations) {
    this.mongoOperations = mongoOperations;
  }

  @Override
  public Long getNextSequenceId(String sequenceName) {
    DatabaseSequence sequence = mongoOperations.findAndModify(
            query(where("_id").is(sequenceName)),
            new Update().inc("seq",1),
            options().returnNew(true).upsert(true),
            DatabaseSequence.class);
    return !Objects.isNull(sequence) ? sequence.sequence() : 1;
  }
}
