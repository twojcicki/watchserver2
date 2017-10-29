package com.jfeesoft.watchserver2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.BinaryWebSocketHandler;

@Component
public class EchoHandler2 extends BinaryWebSocketHandler {

	final static Logger logger = LoggerFactory.getLogger(EchoHandler2.class);

	@Autowired
	private WatchService watchService;

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		watchService.addSession(session);
		logger.info(session.toString());
		session.sendMessage(new TextMessage("CONNECTION ESTABLISHED"));
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		watchService.removeSession(session);
		// session.sendMessage(new TextMessage("CONNECTION CLOSED"));
	}

	/*
	 * @Override protected void handleTextMessage(WebSocketSession session,
	 * TextMessage message) throws Exception { String msg = message.getPayload();
	 * session.sendMessage(new TextMessage("RECEIVED: " + msg)); }
	 */

	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		logger.info(message.getPayload().toString());
		String msg = (String) message.getPayload();
		session.sendMessage(new TextMessage("RECEIVED: " + msg));
	}
}
