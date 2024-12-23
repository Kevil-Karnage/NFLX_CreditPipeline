package nflx.bench.creditpipeline.controller;

import nflx.bench.creditpipeline.dto.Task;
import nflx.bench.creditpipeline.dto.TaskResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;
import java.util.UUID;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TaskControllerTest {

    @Autowired
    private WebTestClient webClient;

    private static final UUID TASK_ID = UUID.fromString("1f937db9-9358-41bd-9bfd-af8891741bc5");
    private static final String TASK_TITLE = "okay, it's title";
    private static final boolean TASK_IS_COMPLETED = true;
    private static final Task TASK = new Task(TASK_ID, TASK_TITLE, TASK_IS_COMPLETED);

    @Test
    @DisplayName("createTask - correct")
    public void testCreateTask() {
        webClient.post().uri("/tasks")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(TASK)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Task.class).isEqualTo(TASK);
    }

    @Test
    @DisplayName("getAllTasks - correct")
    public void testGetAllTasks() {
        webClient.get().uri("/tasks")
                .exchange()
                .expectStatus().isOk()
                .expectBody().equals(List.of(TASK));
    }

    @Test
    @DisplayName("getTaskById - correct")
    public void testGetTaskById() {
        webClient.get().uri("/tasks/" + TASK_ID)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Task.class).isEqualTo(TASK);
    }

    @Test
    @DisplayName("deleteTaskById - correct")
    public void testDeleteTaskById() {
        webClient.delete().uri("/tasks/" + TASK_ID)
                .exchange()
                .expectStatus().isOk()
                .expectBody(TaskResponse.class)
                .isEqualTo(TaskResponse.getSuccessResponse());
    }
}