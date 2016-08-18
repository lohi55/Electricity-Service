package com.powerx.renpower.utilitywebservice.jms;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.jms.listener.SessionAwareMessageListener;
import org.springframework.stereotype.Component;

import com.powerx.renpower.utilitywebservice.service.MessageService;


/**
 * @author Lohith Thota
 * This is JMS Listener class thet listens to the incoming messages
 */
@Component("JMSListener")
public class JMSListener implements SessionAwareMessageListener<TextMessage> {

	public void onMessage(TextMessage message, Session session) throws JMSException {

		if (message instanceof TextMessage) {
			
			String msg;

			msg = ((TextMessage) message).getText();

			String[] msgAry = msg.split(" ");

			int c_id = Integer.parseInt(msgAry[0]);
			int serv_id = Integer.parseInt(msgAry[1]);

			MessageService messService = new MessageService();
			messService.setCustomerService(c_id, serv_id);
		}
	}
}
