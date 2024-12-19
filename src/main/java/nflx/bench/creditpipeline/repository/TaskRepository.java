package nflx.bench.creditpipeline.repository;

import nflx.bench.creditpipeline.dto.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;


import java.util.UUID;


public interface TaskRepository extends ReactiveMongoRepository<Task, UUID> {
}
