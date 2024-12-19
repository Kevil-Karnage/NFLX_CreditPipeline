package nflx.bench.creditpipeline.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TaskResponse {
    private int code;
    private String message;
/*
    public static TaskResponse getSuccessResponse() {
        return new TaskResponse(200, "OK");
    }*/
}
