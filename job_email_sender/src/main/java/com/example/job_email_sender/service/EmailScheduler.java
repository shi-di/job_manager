package com.example.job_email_sender.service;

import com.example.job_email_sender.kafka_consumer.MyTopicConsumerLister;
import com.example.job_email_sender.model.ApprovedJob;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@EnableScheduling
@RequiredArgsConstructor
public class EmailScheduler {

    private final MyTopicConsumerLister myTopicConsumerLister;
    private final ApprovedJobService approvedJobService;


    @Scheduled(fixedRate = 1800000)
    public void startScheduler() {

        List<String> massagesFromTopic = myTopicConsumerLister.getMassagesFromTopic();

        for (String massage : massagesFromTopic) {
            ApprovedJob approvedJob = new ApprovedJob();
            approvedJob.setJobDescription(massage);
            approvedJob.setEmail(approvedJobService.findEmail(massage));
            approvedJobService.getApprovedJob(approvedJob);

        }
    }
}
