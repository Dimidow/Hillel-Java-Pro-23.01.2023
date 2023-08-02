package org.my.homeworks;

import java.io.IOException;
import java.net.Socket;

public class Client {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 8080;

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            System.out.println("Connected to server: " + socket);

            ReadThread readThread = new ReadThread(socket);
            WriteThread writeThread = new WriteThread(socket);

            readThread.start();
            writeThread.start();

            readThread.join();
            writeThread.join();

            socket.close();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}