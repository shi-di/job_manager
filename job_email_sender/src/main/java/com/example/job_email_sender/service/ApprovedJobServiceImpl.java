package com.example.job_email_sender.service;

import com.example.job_email_sender.email_sender.EmailSender;
import com.example.job_email_sender.model.ApprovedJob;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.example.job_email_sender.constant.ApplicationConstant.CONFIRMATION_OF_WORK;
import static com.example.job_email_sender.constant.ApplicationConstant.TO_WHOM;

@Service
@RequiredArgsConstructor
public class ApprovedJobServiceImpl implements ApprovedJobService {

    private final EmailSender emailSender;


    @Override
    public void getApprovedJob(ApprovedJob approvedJob) {

        emailSender.sendMail(CONFIRMATION_OF_WORK, approvedJob.getJobDescription(), approvedJob.getEmail());
    }

    @Override
    public String findEmail(String value) {

        int i = value.indexOf(TO_WHOM) + 6;
        return value.substring(i);
    }
}
