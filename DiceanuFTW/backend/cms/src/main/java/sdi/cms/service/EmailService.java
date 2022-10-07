package sdi.cms.service;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;

    public void sendMessage(final String to, final String subject, final String body) {
        sendMessage(to, subject, body, true);
    }

    @SneakyThrows
    public void sendMessage(final String to, final String subject, final String body, final boolean appendDefaultSignature) {
        final StringBuilder emailBody = new StringBuilder(body);

        if (appendDefaultSignature) {
            emailBody.append("\n\nYours sincerely, the ISS-CMS team.\n\nhttps://youtu.be/dQw4w9WgXcQ");
        }

        final MimeMessagePreparator mailMessage = mimeMessage -> {
            final MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
            message.setFrom("ISS-CMS <noreply@isscms.com>");
            message.setTo(to);
            message.setSubject(subject);
            message.setText(emailBody.toString());
        };

        emailSender.send(mailMessage);
    }

}