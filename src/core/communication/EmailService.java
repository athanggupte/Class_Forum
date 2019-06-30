/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.communication;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import javax.swing.SwingWorker;

/**
 *
 * @author ADMIN
 */
public class EmailService extends SwingWorker{	    //This class is an Asynchronous Task that sends an email to the recipient
    
    java.awt.Component parent;
    
    String mToAddress;
    String mMessageString;
    
    public EmailService(java.awt.Component parent, String pToAddress, String pMessageString) {
	this.parent = parent;
	this.mToAddress = pToAddress;
	this.mMessageString = pMessageString;
    }
    
    public void sendMail() {
	
	final String fromAddress = "adkiller007@gmail.com";
	final String password = "fghmsxyljbjokphp";
	
	Properties properties = System.getProperties();
	properties.put("mail.smtp.host", "smtp.gmail.com");
	properties.put("mail.smtp.port", "465");
	properties.put("mail.smtp.auth", "true");
	properties.put("mail.smtp.starttls.enable", "true");
	
	Session session = Session.getDefaultInstance(properties, 
		new Authenticator() {
		    protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(fromAddress, password);
		    }
	});
	
	try {
	    
	    Message message = new MimeMessage(session);
	    
	    message.setFrom(new InternetAddress(fromAddress));
	    message.setRecipient(Message.RecipientType.TO, new InternetAddress(mToAddress));
	    message.setSubject("Test JavaMail - Gmail SSL");
	    message.setText("Hello,"
		    + "\n" + "\t" + "This message has been sent from a Java application"
		    + "\n" + "Regards");
	    
	    Transport.send(message);
	    
	    System.out.println("Email Sent");
	    
	} catch (MessagingException e) {
	    e.printStackTrace();
	}
    }

    @Override
    protected Object doInBackground() throws Exception {
	sendMail();
	return null;
    }

    @Override
    protected void done() {
	super.done();
	new javax.swing.JOptionPane().showMessageDialog(parent, "Email sent succesfully");
    }
    
    
    
}
