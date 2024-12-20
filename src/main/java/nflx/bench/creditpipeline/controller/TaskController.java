package nflx.bench.creditpipeline.controller;

import nflx.bench.creditpipeline.dto.Task;
import nflx.bench.creditpipeline.dto.TaskResponse;
import nflx.bench.creditpipeline.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping(value = "/tasks", produces = MediaType.APPLICATION_JSON_VALUE)
public class TaskController {

    @Autowired
    private TaskService taskService;

    /**
     * Получение всех задач
     * @return List<Task>
     */
    @GetMapping
    public Flux<Task> getTasks() {
        return taskService.getAllTasks();
    }

    /**
     * Создание задачи
     * @param task
     * @return Task
     */
    @PostMapping
    public Mono<Task> createTask (@RequestBody Task task) {
        return taskService.createTask(task);
    }

    /**
     * Получение задачи по id
     * @param id
     * @return Mono<Task>
     */
    @GetMapping("/{id}")
    public Mono<Task> getTaskById(@PathVariable("id") UUID id) {
        return taskService.getTaskById(id);
    }

    /**
     * Удаление задачи по id
     * @param id
     * @return TaskResponse
     */
    @DeleteMapping("/{id}")
    public TaskResponse deleteTaskById(@PathVariable("id") UUID id) {
        taskService.deleteById(id);
        return TaskResponse.getSuccessResponse();
    }
}
