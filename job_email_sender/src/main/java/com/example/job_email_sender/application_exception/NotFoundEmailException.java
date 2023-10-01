package com.example.job_email_sender.application_exception;

import lombok.Getter;
import lombok.ToString;

import static com.example.job_email_sender.constant.ApplicationConstant.IT_IS_NOT_POSSIBLE_TO_SEND_TO_EMAIL;

@ToString
@Getter
public class NotFoundEmailException extends RuntimeException {

    private final String exceptionMessage = IT_IS_NOT_POSSIBLE_TO_SEND_TO_EMAIL;

}
