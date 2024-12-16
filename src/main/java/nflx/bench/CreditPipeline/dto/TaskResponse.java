package nflx.bench.CreditPipeline.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskResponse {
    private int code;
    private String message;
}
