package com.example.job_email_sender.application_exception;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class NotFoundEmailException extends RuntimeException {

    private final String exceptionMessage = "Не возможно отправить на email";

}
