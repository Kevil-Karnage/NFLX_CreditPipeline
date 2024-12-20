package nflx.bench.creditpipeline.service;

import lombok.RequiredArgsConstructor;
import nflx.bench.creditpipeline.dto.Task;
import nflx.bench.creditpipeline.repository.TaskRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository repository;

    public Mono<Task> createTask(Task task) {
        return repository.save(task);
        }

    public Flux<Task> getAllTasks() {
        return repository.findAll();
    }

    public Mono<Task> getTaskById(UUID id) {
        return repository.findById(id);
    }

    public void deleteById(UUID id) {
        repository.deleteById(id);
    }
}
