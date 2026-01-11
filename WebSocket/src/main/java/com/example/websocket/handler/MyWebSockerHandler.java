package com.example.websocket.handler;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class MyWebSockerHandler extends TextWebSocketHandler {

    private static final Set<WebSocketSession> sessions =
            ConcurrentHashMap.newKeySet();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        session.sendMessage(
                new TextMessage("Connected to server")
        );
        sessions.add(session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessions.remove(session);
        System.out.println("Client disconnected: " + session.getId());
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

        System.out.println("Received message: " + message.getPayload());

        System.out.println("Server sending response...");
        session.sendMessage (new TextMessage("Server response : Hello client"));
    }

    public static void broadcast(String message) throws IOException {
        for (WebSocketSession session : sessions) {
            if(session.isOpen()) {
                session.sendMessage(new TextMessage(message));
            }
        }

    }

}
