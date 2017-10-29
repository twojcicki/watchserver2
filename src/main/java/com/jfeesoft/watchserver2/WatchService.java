package com.jfeesoft.watchserver2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

@Component
public class WatchService {

	private List<WebSocketSession> sessions = new ArrayList<>();

	public void addSession(WebSocketSession session) {
		sessions.add(session);
	}

	public void removeSession(WebSocketSession session) {
		sessions.remove(session);
	}

	public void sendCommand(String command) {
		sessions.forEach(session -> {
			try {
				session.sendMessage(new TextMessage(command));
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}
}
