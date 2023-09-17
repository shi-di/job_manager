package com.example.job_manager_service.service;

import com.example.job_manager_service.model.AuthenticationInfo;
import com.example.job_manager_service.model.UnapprovedJob;
import com.example.job_manager_service.model.ResponsiblePerson;

import java.time.LocalDate;
import java.util.List;

public interface JobManagerService {

    public String saveJobToBase(UnapprovedJob jobForm, String doc);
    public void saveToPersonBase(ResponsiblePerson person);

    public String approveJob(AuthenticationInfo authenticationInfo, LocalDate localDate);
    public List<UnapprovedJob> unapprovedJob(AuthenticationInfo authenticationInfo);
}
