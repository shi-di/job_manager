package com.example.job_email_sender.email_sender;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

import static com.example.job_email_sender.constant.ApplicationConstant.*;

@Configuration
public class JavaEmailConfig {

    @Bean
    public JavaMailSender getMailSender() {

        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost(HOST_YANDEX);
        javaMailSender.setPort(465);
        javaMailSender.setUsername(EMAIL);
        javaMailSender.setPassword(PASSWORD);

        Properties properties = javaMailSender.getJavaMailProperties();
        properties.setProperty(TRANSPORT_PROTOCOL, SMTPS);
        properties.setProperty(MAIL_DEBUG, TRUE);

        return javaMailSender;
    }
}
