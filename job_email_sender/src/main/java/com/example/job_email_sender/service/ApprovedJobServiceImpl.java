package com.example.job_email_sender.service;

import com.example.job_email_sender.email_sender.EmailSender;
import com.example.job_email_sender.model.ApprovedJob;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApprovedJobServiceImpl implements ApprovedJobService {

    private final EmailSender emailSender;


    @Override
    public void getApprovedJob(ApprovedJob approvedJob) {

        emailSender.sendMail("Подтвержденная задача в работу", approvedJob.getJobDescription(), approvedJob.getEmail());
    }

    @Override
    public String findEmail(String value) {

        int i = value.indexOf("кому:") + 6;
        return value.substring(i);
    }
}
