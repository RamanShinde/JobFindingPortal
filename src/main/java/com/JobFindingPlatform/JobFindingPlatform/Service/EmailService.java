package com.JobFindingPlatform.JobFindingPlatform.Service;

import com.JobFindingPlatform.JobFindingPlatform.DTO.EmailRequestDTO;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class EmailService {
    @Value("${spring.mail.username}")
    private String fromEmail;

    @Value("${spring.mail.password}")
    private String password;

    public String sendEmail(EmailRequestDTO dto) {

        if (fromEmail == null || password == null) {
            return "Email credentials not set. Please configure MAIL_USERNAME and MAIL_PASSWORD.";
        }

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.connectiontimeout", "10000");
        props.put("mail.smtp.timeout", "10000");
        props.put("mail.smtp.writetimeout", "10000");

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(dto.getTo()));
            message.setSubject(dto.getSubject());
            message.setText(dto.getBody());

            Transport.send(message);

            return "Email sent successfully to " + dto.getTo();
        } catch (MessagingException e) {
            e.printStackTrace();
            return "Failed to send email: " + e.getMessage();
        }
    }
}
