package mailtwo;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

/*
Отправка письма с файлом
*/

public class mailtwo {

    public static void main(String[] args) {
        mailtwo solution = new mailtwo();
        // solution.sendMail("name.lastname@gmail.com", "password", "friend@gmail.com");
        solution.sendMail("degunino2004@mail.ru", "7DGqhrAHwnSEVRpxq7H8", "bratik.n@yandex.ru");
    }

    public void sendMail(final String username, final String password, final String recipients) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.mail.ru");
        // props.put("mail.smtp.ssl.trust", "smtp.mail.com");
        props.put("mail.smtp.port", "25");
        //  props.put("mail.transport.protocol", "smtps");


        javax.mail.Authenticator authenticator = new javax.mail.Authenticator() {
            @Override
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication(username,password);
            }
        };

        Session session = Session.getInstance(props,authenticator);

        try {
            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(username));
            //  message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipients));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipients));
            final MimeBodyPart mailBody = new MimeBodyPart();
            final Multipart multipart = new MimeMultipart();
            mailBody.setText("Java 20 new features.\nLook at the attachments.");
            multipart.addBodyPart(mailBody);
            message.setContent(multipart);
            // setSubject(message, "Тестовое письмо");
            //  setAttachment(message, "c:\\1\\log.txt");
            // session.getTransport("smtps").sendMessage(message, InternetAddress.parse(recipients));

            // System.out.println("Письмо было отправлено.");
            Transport.send(message);
            System.out.println("Письмо было отправлено.");

        } catch (MessagingException e) {
            System.out.println("Ошибка при отправке: " + e.toString());
        }
    }

    public static void setSubject(Message message, String subject) throws MessagingException {
        message.setSubject(subject);
    }

    public static void setAttachment(Message message, String filename) throws MessagingException {
        message.setText(filename);
    }
}