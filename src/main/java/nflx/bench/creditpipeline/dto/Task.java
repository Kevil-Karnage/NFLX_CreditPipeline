package nflx.bench.creditpipeline.dto;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;


@Data
@Document
public class Task {
    @Id
    private UUID id;

    private String title;

    private Boolean isCompleted;
}
