package nflx.bench.CreditPipeline.dto;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @Id
    private UUID id;
    private String title;
    private Boolean isCompleted;
}
