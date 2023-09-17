package com.example.job_manager_service.service;

import com.example.job_manager_service.model.ApprovedJob;
import org.springframework.stereotype.Service;

import static com.example.job_manager_service.constant.ApplicationConstant.APPROVE_MASSAGE_FOR_EMAIL_SEND;

@Service
public class ProducerToSendServiceImpl implements ProducerToSendService{


    @Override
    public void sendApprovedJob(ApprovedJob approvedJob) {

        String sendEmail = String.format(APPROVE_MASSAGE_FOR_EMAIL_SEND, approvedJob.getJobType(),
                approvedJob.getDataStartJob(), approvedJob.getEmail());


    }
}
