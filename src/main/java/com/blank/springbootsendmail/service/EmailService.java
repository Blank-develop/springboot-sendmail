package com.blank.springbootsendmail.service;

import com.blank.springbootsendmail.EmailDetails;

public interface EmailService {
    String sendSimpleMail(EmailDetails details);
    String sendMailWithAttachment(EmailDetails details);
}
