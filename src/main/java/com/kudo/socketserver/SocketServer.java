/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.kudo.socketserver;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import org.glassfish.tyrus.server.Server;

/**
 *
 * @author HP
 */
public class SocketServer {

    public static void main(String[] args) {
        Server server = new Server("localhost", 8080, "/", null, WebSocketServer.class);
        try {
            System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8.name()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            server.start();
            System.out.println("WebSocket Server đang chạy tại ws://localhost:8080/ws");
            System.out.println("Nhấn Enter để dừng server...");
            new Scanner(System.in).nextLine();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            server.stop();
        }
    }
}
