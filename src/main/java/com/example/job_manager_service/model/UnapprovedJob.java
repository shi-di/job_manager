package com.example.job_manager_service.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document(collection = "Не подтверждённые плановые работы 2023")
public class UnapprovedJob {

    //имя сотрудника инициатор раобот
    private String employeeName;
    //почта сотрудника для подтверждения работы
    private String email;
    //название работ
    private String jobType;
    //
    private LocalDate dataStartJob;
    //описание работ
    private String jobDescription;
    // район
    private String district;
}
