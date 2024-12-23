package nflx.bench.creditpipeline.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nflx.bench.creditpipeline.dto.TaskResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class KafkaProducer {

    @Value("${kafka.topics.test-topic}")
    private String topic;

//    private int messageNumber = 0;

    private final KafkaTemplate<Object, Object> kafkaTemplate;

    public void sendSuccessMessage(String request) {
        sendMessage(request, TaskResponse.getSuccessResponse());
    }


    public void sendMessage(String request, TaskResponse response) {
        KafkaMessage message = new KafkaMessage(request, response);

        kafkaTemplate.send(topic, String.valueOf(message));
    }

    /*
    public void sendMessages() {
        while (messageNumber != 10_000) {
            messageNumber++;
            JsonMessage jsonMessage = JsonMessage.builder()
                    .number(messageNumber)
                    .message("message number " + messageNumber)
                    .build();
            kafkaTemplate.send(topic, String.valueOf(ThreadLocalRandom.current().nextLong()), jsonMessage);
            log.info("Отправлено сообщение номер {}", messageNumber);
        }
    }
    */
}