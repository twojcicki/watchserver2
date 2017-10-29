package com.jfeesoft.watchserver2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfiguration implements WebSocketConfigurer {

	@Autowired
	private EchoHandler echoHandler;
	@Autowired
	private EchoHandler2 echoHandler2;

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(echoHandler, "/name").setAllowedOrigins("*");
		registry.addHandler(echoHandler2, "/name2").setAllowedOrigins("*");
	}
}
