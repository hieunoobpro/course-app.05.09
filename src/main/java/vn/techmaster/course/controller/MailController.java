package vn.techmaster.course.controller;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController  {
    @Autowired
    public JavaMailSender emailSender;

    @PostMapping ("/send-simple-email")
    public String sendSimpleEmail() {
        // Create a Simple MailMessage.
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo("hieuzzdz@gmail.com");
        message.setSubject("Hieu Simple Email");
        message.setText("Hello Techmaster");

        // Send Message!
        emailSender.send(message);

        return "Email Sent!";
    }
}
