/**
 * 
 */
package com.pedro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

/**
 * @author pedro
 *
 */

@Component
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
	
}
