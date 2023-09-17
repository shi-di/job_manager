package com.example.job_manager_service.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ScheduledJob {

    private String jobType;
    private LocalDate dateRegistrationJob;
    private LocalDate dataStartJob;
}
