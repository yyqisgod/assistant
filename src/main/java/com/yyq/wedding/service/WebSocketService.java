package com.yyq.wedding.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Component
@ServerEndpoint("/webSocket")
@Slf4j
public class WebSocketService {

    private static final Set<Session> sessions = Collections.synchronizedSet(new HashSet<>());


    @OnOpen
    public void onOpen(Session session) {
        sessions.add(session);
        log.info("【websocket消息】有新的连接");
    }

    @OnClose
    public void onClose() {
        log.info("【websocket消息】连接断开");
    }

    @OnMessage
    public void onMessage(String message) {
        log.info("【websocket消息】收到客户端发来的消息：{}", message);
    }

    public void sendMessage(String message) {
        for (Session session : sessions) {
            try {
                session.getBasicRemote().sendText(message);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}