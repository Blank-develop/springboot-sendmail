package com.blank.springbootsendmail.controller;

import com.blank.springbootsendmail.EmailDetails;
import com.blank.springbootsendmail.kafka.KafkaProducer;
import com.blank.springbootsendmail.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {
    @Autowired
    private EmailService emailService;
    private KafkaProducer kafkaProducer;

    public EmailController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    // Sending a simple Email
    @PostMapping("/sendMail")
    public String sendMail(@RequestBody EmailDetails details) {
        return emailService.sendSimpleMail(details);
    }

    // Sending email with attachment
    @PostMapping("/sendMailWithAttachment")
    public String sendMailWithAttachment(@RequestBody EmailDetails details) {

        return emailService.sendMailWithAttachment(details);
    }
}
