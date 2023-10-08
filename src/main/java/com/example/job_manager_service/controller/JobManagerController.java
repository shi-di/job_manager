package com.example.job_manager_service.controller;

import com.example.job_manager_service.model.AuthenticationInfo;
import com.example.job_manager_service.model.UnapprovedJob;
import com.example.job_manager_service.model.ResponsiblePerson;
import com.example.job_manager_service.service.JobManagerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

import static com.example.job_manager_service.constant.ApplicationConstant.*;

@RestController
@RequiredArgsConstructor
@Tag(name = JOB_MANAGER, description = SCHEDULED_WORK_MANAGEMENT_SERVICE)
public class JobManagerController {

    private final JobManagerService jobManagerService;

    @PostMapping(ADD_NEW_JOB)
    @Operation(summary = REGISTRATION_OF_NEW_WORKS_FOR_CHECKING)
    @Parameter(name = DOC, description = DOCUMENT_NAME, example = PLANNED_WORK)
    public String saveUnapprovedJob(@RequestBody UnapprovedJob jobForm, @RequestParam String doc) {

        return jobManagerService.saveJobToBase(jobForm, doc);
    }

    @PostMapping(ADD_RESPONSIBLE_PERSON)
    @Operation(summary = REGISTRATION_OF_RESPONSIBLE_PERSON)
    public void saveResponsiblePerson(@RequestBody ResponsiblePerson person) {

        jobManagerService.saveToPersonBase(person);
    }

    @PostMapping(APPROVED_JOB)
    @Operation(summary = WORK_CONFIRMATION_SENDING_MAIL)
    public void approveJob(@RequestBody AuthenticationInfo authenticationInfo, @RequestParam LocalDate localDate) {

        jobManagerService.approveJob(authenticationInfo, localDate);
    }

    @PostMapping(LIST_UNAPPROVED_JOB)
    @Operation(summary = FULL_LIST_OF_UNCONFIRMED_WORKS)
    public void listUnapprovedJob(@RequestBody AuthenticationInfo authenticationInfo) {

        jobManagerService.unapprovedJob(authenticationInfo);
    }
}
