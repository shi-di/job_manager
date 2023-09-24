package com.example.job_manager_service.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document(collection = "Подтвержденные Плавновые работы 2023")
public class ApprovedJob {

    //имя сотрудника инициатор раобот
    private String employeeName;
    //почта сотрудника для подтверждения работы
    private String email;
    //название должности
    private String jobType;
    //
    private LocalDate dataStartJob;
    //описание работ
    private String jobDescription;
    // район
    private String district;
    // ответственное лицо
    private String responsiblePerson;

}
