package com.example.job_email_sender.kafka_consumer;

import lombok.Getter;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.example.job_email_sender.constant.ApplicationConstant.KAFKA_SANDBOX;
import static com.example.job_email_sender.constant.ApplicationConstant.MY_TOPIC;

@Component
@Getter
public class MyTopicConsumerLister {

    private final List<String> massagesFromTopic = new ArrayList<>();

    @KafkaListener(topics = MY_TOPIC, groupId = KAFKA_SANDBOX)
    public void listen(String massage) {

        synchronized (massagesFromTopic) {
            massagesFromTopic.add(massage);
        }
    }
}
