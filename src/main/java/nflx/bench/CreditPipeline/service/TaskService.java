package nflx.bench.CreditPipeline.service;

import nflx.bench.CreditPipeline.dto.Task;
import nflx.bench.CreditPipeline.repository.TaskRepository;

import java.util.List;
import java.util.UUID;

public class TaskService {
    TaskRepository repository;

    public void createTask(Task task) {

    }

    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    public Task getTaskById(UUID id) {
        try {
            return repository.findById(id).get();
        } catch (Exception e) {
            throw new RuntimeException("Not found task with that id");
        }
    }

    public Task deleteById(UUID id) {
        return new Task();
    }
}
