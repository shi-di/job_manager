package com.example.job_email_sender.controller;

import com.example.job_email_sender.model.ApprovedJob;
import com.example.job_email_sender.service.ApprovedJobService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MailSendingController {

    private final ApprovedJobService approvedJobService;
    @PostMapping("job-confirmation")
    public void sendingLetter(@RequestBody ApprovedJob approvedJob) {

        approvedJobService.getApprovedJob(approvedJob);

    }

}
