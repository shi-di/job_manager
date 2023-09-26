package com.example.job_manager_service.service;

import com.example.job_manager_service.model.ApprovedJob;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static com.example.job_manager_service.constant.ApplicationConstant.APPROVE_MASSAGE_FOR_EMAIL_SEND;

@Service
@RequiredArgsConstructor
public class ProducerToSendServiceImpl implements ProducerToSendService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void sendApprovedJob(ApprovedJob approvedJob) {

        String sendEmail = String.format(APPROVE_MASSAGE_FOR_EMAIL_SEND, approvedJob.getJobType(), approvedJob.getJobDescription(),
                approvedJob.getDataStartJob(), approvedJob.getEmail());

        kafkaTemplate.send("myTopic", sendEmail);
    }
}
