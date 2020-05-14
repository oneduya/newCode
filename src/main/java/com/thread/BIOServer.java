package com.thread;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class BIOServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        new Thread(() ->{
            int a = 111;
            while(true) {
                try {
                    System.out.println("wait for connection...");
                    Socket socket = serverSocket.accept();
                    System.out.println("connection successfully");

                    new Thread(() -> {
                        int len = 0;
                        byte[] data = new byte[1024];
                        try {
                            while (true) {
                                System.out.println("wait for data...");
                                //阻塞
                                InputStream inputStream = socket.getInputStream();
                                // 按字节流方式读取数据
                                while ((len = inputStream.read(data)) != -1) {
                                    System.out.println(new String(data, 0, len));
                                }
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
