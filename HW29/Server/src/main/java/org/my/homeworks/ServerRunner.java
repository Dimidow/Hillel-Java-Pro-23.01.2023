package org.my.homeworks;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerRunner {
    private static final int PORT = 8080;
    private static final List<ClientHandler> clients = new ArrayList<>();

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server started. Listening on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket);

                ClientHandler clientHandler = new ClientHandler(clientSocket);
                clients.add(clientHandler);
                clientHandler.start();

                notifyAllClients("New client connected: " + clientHandler.getClientName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void removeClient(ClientHandler clientHandler) {
        clients.remove(clientHandler);
    }

    public static void notifyAllClients(String message) {
        for (ClientHandler client : clients) {
            client.sendMessage("[SERVER] " + message);
        }
    }
}