package nflx.bench.CreditPipeline.controller;

import nflx.bench.CreditPipeline.dto.Task;
import nflx.bench.CreditPipeline.dto.TaskResponse;
import nflx.bench.CreditPipeline.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private TaskService taskService;

    /**
     * получение всех задач
     */
    @GetMapping
    public List<Task> getTasks() {
        return taskService.getAllTasks();
    }

    /**
     * создание задачи
     */
    @PostMapping
    public TaskResponse createTask (Task task) {
        taskService.createTask(task);

        return new TaskResponse(200, "OK");
    }

    /**
     * получение задачи по id
     */
    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable("id") UUID id) {
        return taskService.getTaskById(id);
    }


    /**
     * удаление задачи по id
     */
    @DeleteMapping("/{id}")
    public Task deleteTaskById(@PathVariable("id") UUID id) {
        return taskService.deleteById(id);
    }
}
