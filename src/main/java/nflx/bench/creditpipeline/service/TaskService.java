package nflx.bench.creditpipeline.service;

import nflx.bench.creditpipeline.dto.Task;
import nflx.bench.creditpipeline.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

@Service
public class TaskService {
    @Autowired
    private TaskRepository repository;

    public Task createTask(Task task) {
        Mono<Task> saved = repository.save(task);
        return saved.block();
    }

    public List<Task> getAllTasks() {
        return repository.findAll().collectList().block();
    }

    public Task getTaskById(UUID id) {
        return repository.findById(id).block();
    }

    public void deleteById(UUID id) {
        repository.deleteById(id);
    }
}
