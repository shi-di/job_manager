package com.example.job_email_sender.controller;

import com.example.job_email_sender.kafka_consumer.MyTopicConsumerLister;
import com.example.job_email_sender.service.ApprovedJobService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.example.job_email_sender.constant.ApplicationConstant.JOB_CONFIRMATION;

@RestController
@RequiredArgsConstructor
public class MailSendingController {

    private final ApprovedJobService approvedJobService;
    private final MyTopicConsumerLister myTopicConsumerLister;

    @PostMapping(JOB_CONFIRMATION)
    public void sendingLetter() {

        List<String> massagesFromTopic = myTopicConsumerLister.getMassagesFromTopic();

    }

}
