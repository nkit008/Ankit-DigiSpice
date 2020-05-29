import java.io.*;
import java.util.*;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;

import org.apache.log4j.Logger;

public class SendFile
{
	private static final Logger LOGGER = Logger.getLogger(SendFile.class.getName());

    private class SMTPAuthenticator extends Authenticator
    {

        public PasswordAuthentication getPasswordAuthentication()
        {
        	LOGGER.info("in PasswordAuthentication");
            String s = new ConnectionConfig().getValuefromProperties("mail_from");
            String s1 = new ConnectionConfig().getValuefromProperties("mail_pwd");
            return new PasswordAuthentication(s, s1);
        }

        final SendFile this$0;

        private SMTPAuthenticator()
        {
            this$0 = SendFile.this;
           // super();
        }

    }


    public boolean sendMessage(String s, String s1, String s2, String s3, String s4, String s5)
        throws Exception
    {
        Properties properties = System.getProperties();
        properties.setProperty("mail.host", new ConnectionConfig().getValuefromProperties("smtpServ"));
        properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.starttls.enable", "true");
        SMTPAuthenticator smtpauthenticator = new SMTPAuthenticator();
        Session session = Session.getDefaultInstance(properties, smtpauthenticator);
        //session.setDebug(true);
        try
        {
            MimeMessage mimemessage = new MimeMessage(session);
            LOGGER.info("*************** Starting Send Mail Program ************");
            System.out.println((new StringBuilder()).append("Sender     : ").append(s).toString());
            System.out.println((new StringBuilder()).append("To         : ").append(s1).toString());
            System.out.println((new StringBuilder()).append("ccTo       : ").append(s2).toString());
            System.out.println((new StringBuilder()).append("Subject :").append(s3).toString());
            InternetAddress internetaddress = new InternetAddress(s);
            mimemessage.setFrom(internetaddress);
            Date date = new Date();
            date.setDate(date.getDate() - 1);
            String s6 = "";
            if((new Integer(date.getMonth() + 1)).toString().length() == 1)
                s6 = (new StringBuilder()).append(s6).append("0").append(date.getMonth() + 1).toString();
            else
                s6 = (new StringBuilder()).append(s6).append(date.getMonth() + 1).toString();
            if((new Integer(date.getDate())).toString().length() == 1)
                s6 = (new StringBuilder()).append(s6).append("0").append(date.getDate()).toString();
            else
                s6 = (new StringBuilder()).append(s6).append(date.getDate()).toString();
            System.out.println(s6);
           // s3 = (new StringBuilder()).append(s3).append(s6).toString();
            InternetAddress ainternetaddress[];
            for(StringTokenizer stringtokenizer = new StringTokenizer(s1, ","); stringtokenizer.hasMoreTokens(); mimemessage.addRecipients(javax.mail.Message.RecipientType.TO, ainternetaddress))
                ainternetaddress = (new InternetAddress[] {
                    new InternetAddress(stringtokenizer.nextToken())
                });
                                                if(!s2.equalsIgnoreCase("#")) //if not send mail to cc
                                                {

                                                                InternetAddress ainternetaddress1[];
                                                                for(StringTokenizer stringtokenizer1 = new StringTokenizer(s2, ","); stringtokenizer1.hasMoreTokens(); mimemessage.addRecipients(javax.mail.Message.RecipientType.CC, ainternetaddress1))
                                                                                ainternetaddress1 = (new InternetAddress[] {
                                                                                                new InternetAddress(stringtokenizer1.nextToken())
                                                                                });
                                                }
            mimemessage.setSubject(s3);
            mimemessage.setContent(s4, "text/html");
            MimeMultipart mimemultipart = new MimeMultipart();
            MimeBodyPart mimebodypart = new MimeBodyPart();
            mimebodypart.setDisposition("inline");
            mimebodypart.setContent(s4, "text/html");
            mimemultipart.addBodyPart(mimebodypart);
            
            Transport transport = session.getTransport("smtp");
            String s9 = "idea.obd@digispice.com";
            String s10 = "idea@1234";

            //String s9 = "rahul.kaushik@spicedigital.in";                         //"cc-e00069";
           //String s10 = "spice@123";           //"khushi@123";
            try
            {
            	LOGGER.info("Trying to connect...");
                transport.connect(strMailHost, s9, s10);
                System.out.println((new StringBuilder()).append("Hopefully\t\t\tconnected...").append(transport.toString()).toString());
            }
            catch(AuthenticationFailedException authenticationfailedexception)
            {
            	LOGGER.info("Transport connect failed", authenticationfailedexception);
            }
            mimemessage.saveChanges();
            Transport _tmp = transport;
            Transport.send(mimemessage);
            transport.close();
            LOGGER.info("************** Finish Mail ************");
            return true;
        }
        catch(MessagingException messagingexception)
        {
        	LOGGER.info("------------------ Error -------------", messagingexception);
            messagingexception.printStackTrace();
            LOGGER.info("exec************** Finish Mail ************");
            return false;
        }
    }
                public static String strMailHost = "smtp.gmail.com";
                
                

}
