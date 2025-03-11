/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kudo.socketserver;
import com.google.gson.Gson;
import com.kudo.socketserver.domain.CaculateRequest;
import com.kudo.socketserver.enums.OperationMethod;
import jakarta.websocket.*;

import java.io.IOException;
import java.net.URI;
import java.util.Scanner;

@ClientEndpoint
public class WebSocketClient {
    private Session session;
    private static Gson gson = new Gson();

    public WebSocketClient(String serverUri) {
        try {
            WebSocketContainer container = ContainerProvider.getWebSocketContainer();
            container.connectToServer(this, URI.create(serverUri));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        System.out.println("Connected to server.");
        try {
            CaculateRequest rq = new CaculateRequest(4, 5, OperationMethod.CONG);
                    
            session.getBasicRemote().sendText(gson.toJson(rq));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnMessage
    public void onMessage(String message) {
        System.out.println("Received from server: " + message);
    }

    @OnClose
    public void onClose() {
        System.out.println("Connection closed.");
    }

    public static void main(String[] args) {
        new WebSocketClient("ws://localhost:8080/caculate");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
    }
}

