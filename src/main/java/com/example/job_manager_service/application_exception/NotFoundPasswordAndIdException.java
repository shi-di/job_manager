package com.example.job_manager_service.application_exception;

import lombok.Getter;

@Getter
public class NotFoundPasswordAndIdException extends RuntimeException {

    private final String exceptionMessage = "Уникальный идентификатор или пароль не верный";

}
