/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kudo.socketserver;

import jakarta.websocket.*;
import jakarta.websocket.server.ServerEndpoint;
import java.io.IOException;

@ServerEndpoint("/notification")
public class NotificationEndpoint {
    @OnOpen
    public void onOpen(Session session) {
        System.out.println("Client connected to /notification: " + session.getId());
    }

    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        System.out.println("Received in /notification: " + message);
        session.getBasicRemote().sendText("Notification response: " + message);
    }

    @OnClose
    public void onClose(Session session) {
        System.out.println("Client disconnected from /notification: " + session.getId());
    }
}

