package com.anthony.io.nio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class BioServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(3333);
        new Thread(() -> {
            while (true) {
                try {
                    Socket socket = serverSocket.accept();
                    new Thread(() -> {
                        int len;
                        byte[] data = new byte[1024];
                        try {
                            InputStream is = socket.getInputStream();
                            while ((len = is.read(data)) != -1) {
                                System.out.println(new String(data));
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }).start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
