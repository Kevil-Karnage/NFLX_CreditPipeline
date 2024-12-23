package nflx.bench.creditpipeline.kafka;

import lombok.AllArgsConstructor;
import lombok.Data;
import nflx.bench.creditpipeline.dto.TaskResponse;

@Data
@AllArgsConstructor
public class KafkaMessage {
    private String request;
    private TaskResponse response;
}
