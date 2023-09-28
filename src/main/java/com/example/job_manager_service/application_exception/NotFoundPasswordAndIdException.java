package com.example.job_manager_service.application_exception;

import lombok.Getter;

import static com.example.job_manager_service.constant.ApplicationConstant.WRONG_PASSWORD;

@Getter
public class NotFoundPasswordAndIdException extends RuntimeException {

    private final String exceptionMessage = WRONG_PASSWORD;

}
