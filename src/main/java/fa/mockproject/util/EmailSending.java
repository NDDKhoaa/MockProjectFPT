package fa.mockproject.util;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class EmailSending {

    public static void sendEmail(String email, String subject, String messageSending,
                                 JavaMailSender emailSender) {

        try {
            MimeMessage message = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
            helper.setTo(email);
            helper.setSubject(subject);
            helper.setText(messageSending, true);
            emailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }


}
