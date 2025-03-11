/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kudo.socketserver;

/**
 *
 * @author HP
 */
import jakarta.websocket.*;
import jakarta.websocket.server.ServerEndpoint;
import java.io.IOException;
import com.google.gson.Gson;
import com.kudo.socketserver.domain.CaculateRequest;
import com.kudo.socketserver.enums.OperationMethod;

@ServerEndpoint("/caculate")
public class CaculateEndpoint {
    private static Gson gson = new Gson();
    @OnOpen
    public void onOpen(Session session) {
        System.out.println("Client connected to /chat: " + session.getId());
    }

    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        CaculateRequest rq = gson.fromJson(message, CaculateRequest.class);
        StringBuilder str = new StringBuilder();
        switch (rq.getMethod()) {
            case OperationMethod.CONG :
                str.append("Kết quả phép cộng của 2 số ");
                display(str, rq);
                break;
            case OperationMethod.TRU :
                str.append("Kết quả phép trừ của 2 số ");
                display(str, rq);
                break;
            case OperationMethod.NHAN :
                str.append("Kết quả phép nhân của 2 số ");
                display(str, rq);
                break;
            case OperationMethod.CHIA :
                str.append("Kết quả phép chia của 2 số ");
                display(str, rq);
                break;
            default:
                throw new AssertionError();
        }
        session.getBasicRemote().sendText("Chat response: " + str.toString());
    }

    @OnClose
    public void onClose(Session session) {
        System.out.println("Client disconnected from /chat: " + session.getId());
    }
    
    public void display(StringBuilder str, CaculateRequest rq){
        str.append(String.valueOf(rq.getNumber1()));
        str.append(" và ");
        str.append(String.valueOf(rq.getNumber2()));
        str.append(" là: ");
        str.append(String.valueOf(rq.getNumber1()+rq.getNumber2()));
    }
}
