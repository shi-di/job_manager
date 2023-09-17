package com.example.job_manager_service.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Список ответственных лиц")
public class ResponsiblePerson {

    private String personalId;
    private String approvePassword;
    private String name;
    private String jobTitle;
    private String district;

}
