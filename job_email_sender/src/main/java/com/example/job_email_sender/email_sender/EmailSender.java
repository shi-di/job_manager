package com.example.job_email_sender.email_sender;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import static com.example.job_email_sender.constant.ApplicationConstant.EMAIL;

@Service
@RequiredArgsConstructor
public class EmailSender {

    private final JavaMailSender mailSender;

    public void sendMail(String mailName, String text, String sendTo) {

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(EMAIL);
        simpleMailMessage.setTo(sendTo);
        simpleMailMessage.setText(text);
        simpleMailMessage.setSubject(mailName);

        mailSender.send(simpleMailMessage);
    }


}
