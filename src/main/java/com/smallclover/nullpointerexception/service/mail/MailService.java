package com.smallclover.nullpointerexception.service.mail;

/**
 * @author Amadeus
 * @date 2020-06-20
 */
public interface MailService {
    void sendMailMessage(String to, String subject, String content);
}
