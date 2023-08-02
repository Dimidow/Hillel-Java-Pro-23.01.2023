package org.my.homeworks;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;

public class ClientHandler extends Thread {
    private final String clientName;
    private final Socket clientSocket;
    private final PrintWriter out;
    private final BufferedReader in;

    public ClientHandler(Socket clientSocket) throws IOException {
        this.clientName = "client-" + new Random().nextInt(1000);
        this.clientSocket = clientSocket;
        this.out = new PrintWriter(clientSocket.getOutputStream(), true);
        this.in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    public String getClientName() {
        return clientName;
    }

    public void sendMessage(String message) {
        out.println(message);
    }

    @Override
    public void run() {
        try {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                if ("-exit".equals(inputLine)) {
                    ServerRunner.notifyAllClients(clientName + " has disconnected.");
                    break;
                } else if (inputLine.startsWith("-file")) {
                    String filePath = inputLine.substring("-file".length()).trim();
                    receiveFile(filePath);
                } else {
                    ServerRunner.notifyAllClients(clientName + ": " + inputLine);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                out.close();
                clientSocket.close();
                ServerRunner.removeClient(this);
                System.out.println("Client disconnected: " + clientName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void receiveFile(String filePath) throws IOException {
        try (
            BufferedInputStream bis = new BufferedInputStream(clientSocket.getInputStream());
            FileOutputStream fos = new FileOutputStream(filePath)) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            System.out.println("File received and saved: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}