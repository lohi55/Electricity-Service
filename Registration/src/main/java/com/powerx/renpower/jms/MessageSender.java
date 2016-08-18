package com.powerx.renpower.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class MessageSender {
	
	@Autowired
	private JmsTemplate jmsTemplate;

	public void sendMessage(final String message) {
		jmsTemplate.send(new MessageCreator() {

			
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(message);
			}
		});
	}
}
