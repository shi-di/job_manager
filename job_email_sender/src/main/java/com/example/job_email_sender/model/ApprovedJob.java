package com.example.job_email_sender.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ApprovedJob {

    private String employeeName;
    private String email;
    private String jobType;
    private LocalDate dataStartJob;
    private String jobDescription;
    private String district;
    private String responsiblePerson;
}
