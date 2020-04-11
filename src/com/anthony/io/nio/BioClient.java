package com.anthony.io.nio;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;

public class BioClient {
    public static void main(String[] args) {
        new Thread(() -> {
            try {
                Socket socket = new Socket("127.0.0.1", 3333);
                while (true) {
                    String str = new Date() + " ~~~ Anthony!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!";
                    socket.getOutputStream().write(str.getBytes());
                    System.out.println(str);
                    Thread.sleep(1000);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
