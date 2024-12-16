package nflx.bench.CreditPipeline.repository;

import nflx.bench.CreditPipeline.dto.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskRepository extends MongoRepository<Task, UUID> {

    Optional<Task> findById(UUID id);
    List<Task> findAll();

}
