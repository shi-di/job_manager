package com.example.job_email_sender.kafka_consumer;

import lombok.Getter;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class MyTopicConsumerLister {

    private final List<String> massagesFromTopic = new ArrayList<>();

    @KafkaListener(topics = "myTopic", groupId = "kafka-sandbox")
    public void listen(String massage) {

        synchronized (massagesFromTopic) {
            massagesFromTopic.add(massage);
        }
    }
}
