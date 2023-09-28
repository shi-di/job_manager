package com.example.job_manager_service.application_exception;

import lombok.Getter;

import static com.example.job_manager_service.constant.ApplicationConstant.NO_PLANNED_WORK;

@Getter
public class NotFoundUnapprovedJobException extends RuntimeException {

    private final String exceptionMessage = NO_PLANNED_WORK;
}
