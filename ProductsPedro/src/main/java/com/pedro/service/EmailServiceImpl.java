/**
 * 
 */
package com.pedro.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * @author pedro
 *
 */

@Service
public class EmailServiceImpl implements EmailService {
	
	@Autowired
	public JavaMailSender jms;
	
	@Override
	public void enviarEmail(String receptor) {
		
		SimpleMailMessage m = new SimpleMailMessage(); 
        m.setTo(receptor); 
        m.setSubject("Compra realizada");
        m.setText("Su pedido se enviará de forma inmediata! Esperemos que sea de su agrado haber comprado en nuestra compañia! Le esperamos de nuevo, un saludo!!");
        jms.send(m);
				
	}
	
	public void enviarCorreo(String receptor, String asunto, String cuerpo) {
		
		/* El remitente será la cuenta desde donde se enviará el gmail. */
	    String emisor = "perezprueba55@gmail.com";

	    /* Properties para enviar el correo. */
	    Properties props = System.getProperties();
	    props.put("mail.smtp.host", "smtp.gmail.com"); /* Servidor de correo */
	    
	    props.put("mail.smtp.user", emisor); /* Correo del emisor */
	    
	    props.put("mail.smtp.clave", "pp55#cohete"); /* Contrasena del correo remitente */
	    
	    props.put("mail.smtp.auth", "true"); /* Para que se pueda autenticar. */
	    
	    props.put("mail.smtp.starttls.enable", "true"); /* Nos permite realizar la conexion de una forma segura */
	    
	    props.put("mail.smtp.port", "587"); /* Puerto seguro que utiliza Google */

	    Session session = Session.getDefaultInstance(props);
	    MimeMessage message = new MimeMessage(session);

	    try {
	        message.setFrom(new InternetAddress(emisor));
	        message.addRecipients(Message.RecipientType.TO, receptor); /* Aqui podemos añadir mas de un destinatario. */
	        message.setSubject(asunto); /* Asunto del correo */
	        message.setText(cuerpo); /* Cuerpo donde se desarrolla el correo. */
	        Transport transport = session.getTransport("smtp");
	        transport.connect("smtp.gmail.com", emisor, "pp55#cohete");
	        transport.sendMessage(message, message.getAllRecipients()); /* Aqui es donde se envia el mensaje */
	        transport.close();
	    }
	    catch (MessagingException me) {
	        me.printStackTrace();
	    }
	}
	
}
