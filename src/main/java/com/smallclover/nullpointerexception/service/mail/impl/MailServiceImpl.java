package com.smallclover.nullpointerexception.service.mail.impl;

import com.smallclover.nullpointerexception.service.mail.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author Amadeus
 * @date 2020-06-20
 */
@Service
@Slf4j
public class MailServiceImpl implements MailService {

    @Autowired
    JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String from;

    @Async
    @Override
    public void sendMailMessage(String to, String subject, String content) {
        var simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(from);
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(content);
        simpleMailMessage.setSentDate(Date.valueOf(LocalDate.now()));

        try {
            log.debug("邮件发送开始");
            javaMailSender.send(simpleMailMessage);
            log.debug("邮件发送结束");
        }catch (Exception e){
            e.printStackTrace();
            log.warn("邮件发送异常");
        }

    }
}
