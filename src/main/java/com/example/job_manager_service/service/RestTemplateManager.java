package com.example.job_manager_service.service;

import com.example.job_manager_service.model.ApprovedJob;

public interface RestTemplateManager {

    public void sendApprovedJobByEmail(ApprovedJob approvedJob);
}
