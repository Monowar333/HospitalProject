/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HospitalWeb.mail;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMailImpl implements SendMail{
    @Override
    public void sendMail(String mail, String name, String href) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                        "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props,
            new GMailAuthenticator(
                    CredentialsBundle.resolveCredentials("username"),
                    CredentialsBundle.resolveCredentials("password")
            )
        );

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("monowar333@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                            InternetAddress.parse(mail));
            message.setSubject("Testing Subject");
            message.setContent("<!DOCTYPE html>" +
                    "\n\n<html>"+
                    "\n\n<head>"+
                    "\n\n<title> Dear " + name + ",\"</title>" +
                    "\n\n</head>" +
                    "\n\n<body>" + 
                    "\n\n<h1>ACCEPT " +  href + "</h1>"+
                    "\n\n</body>"+
                    "\n\n</html>", "text/html");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
                throw new RuntimeException(e);
        }
    }
    
    static class GMailAuthenticator extends Authenticator {
     String user;
     String pw;
     public GMailAuthenticator (String username, String password)
     {
        super();
        this.user = username;
        this.pw = password;
     }
    public PasswordAuthentication getPasswordAuthentication()
    {
       return new PasswordAuthentication(user, pw);
    }
}
}