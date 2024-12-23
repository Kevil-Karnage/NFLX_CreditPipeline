package nflx.bench.creditpipeline.controller;

import nflx.bench.creditpipeline.dto.Task;
import nflx.bench.creditpipeline.dto.TaskResponse;
import nflx.bench.creditpipeline.kafka.KafkaProducer;
import nflx.bench.creditpipeline.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

import static nflx.bench.creditpipeline.dto.enums.TaskRequests.*;

@RestController
@RequestMapping(value = "/tasks", produces = MediaType.APPLICATION_JSON_VALUE)
public class TaskController {

// TODO: ExceptionHandler с обработкой исключений

    @Autowired
    private TaskService taskService;

    @Autowired
    private KafkaProducer producer;

    /**
     * Получение всех задач
     * @return List<Task>
     */
    @GetMapping
    public Flux<Task> getTasks() {
        Flux<Task> tasks = taskService.getAllTasks();
        producer.sendSuccessMessage(TASKS_GET_ALL.name());
        return tasks;
    }

    /**
     * Создание задачи
     * @param task
     * @return Task
     */
    @PostMapping
    public Mono<Task> createTask (@RequestBody Task task) {
        Mono<Task> response =  taskService.createTask(task);
        producer.sendSuccessMessage(TASKS_CREATE_NEW.name());
        return response;
    }

    /**
     * Получение задачи по id
     * @param id
     * @return Mono<Task>
     */
    @GetMapping("/{id}")
    public Mono<Task> getTaskById(@PathVariable("id") UUID id) {
        Mono<Task> response = taskService.getTaskById(id);
        producer.sendSuccessMessage(TASKS_GET_BY_ID.name());
        return response;
    }

    /**
     * Удаление задачи по id
     * @param id
     * @return TaskResponse
     */
    @DeleteMapping("/{id}")
    public TaskResponse deleteTaskById(@PathVariable("id") UUID id) {
        taskService.deleteById(id);
        producer.sendSuccessMessage(TASKS_DELETE_BY_ID.toString());
        return TaskResponse.getSuccessResponse();
    }
}
