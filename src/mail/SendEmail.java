package mail;

import java.util.Properties;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class SendEmail {
    public static void main(String [] args) throws MessagingException {
        String to = "degunino2004@mail.ru";
        String subject = "subject";
        String msg ="email text....";
        final String from ="degunino2004@mail.ru";
        final  String password ="**********";


        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.host", "smtp.mail.ru");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        props.put("mail.debug", "true");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");
        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(from,password);
                    }
                });

        //session.setDebug(true);
        Transport transport = session.getTransport();
        InternetAddress addressFrom = new InternetAddress(from);

        MimeMessage message = new MimeMessage(session);
        message.setSender(addressFrom);
        message.setSubject(subject);
        message.setContent(msg, "text/plain");
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

        transport.connect();
        Transport.send(message);
        transport.close();
    }
}
