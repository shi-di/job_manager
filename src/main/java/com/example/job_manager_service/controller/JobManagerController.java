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

@RestController
@RequiredArgsConstructor
@Tag(name = "job manager", description = "Сервис для управления плановыми работами")
public class JobManagerController {

    private final JobManagerService jobManagerService;

    @PostMapping("add-new-job")
    @Operation(summary = "Регистрация новых работ на проверку")
    @Parameter(name = "doc", description = "название документа", example = "Плановые работы")
    public String saveUnapprovedJob(@RequestBody UnapprovedJob jobForm, @RequestParam String doc) {

        return jobManagerService.saveJobToBase(jobForm, doc);
    }

    @PostMapping("add-responsible-person")
    @Operation(summary = "Регистрация ответственного лица")
    public void saveResponsiblePerson(@RequestBody ResponsiblePerson person) {

        jobManagerService.saveToPersonBase(person);
    }

    @PostMapping("approve-job")
    @Operation(summary = "Подтверждение работ из списка с отправкой уведомления")
    public void approveJob(@RequestBody AuthenticationInfo authenticationInfo, @RequestParam LocalDate localDate) {

        jobManagerService.approveJob(authenticationInfo, localDate);
    }

    @PostMapping("list-unapproved-job")
    @Operation(summary = "Полный список не подтверждённых работ")
    public void listUnapprovedJob(@RequestBody AuthenticationInfo authenticationInfo) {

        jobManagerService.unapprovedJob(authenticationInfo);
    }
}
