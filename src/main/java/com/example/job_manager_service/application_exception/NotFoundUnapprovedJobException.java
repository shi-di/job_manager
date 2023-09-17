package com.example.job_manager_service.application_exception;

import lombok.Getter;

@Getter
public class NotFoundUnapprovedJobException extends RuntimeException {

    private final String exceptionMessage = "Отсутствуют плановые работы";
}
