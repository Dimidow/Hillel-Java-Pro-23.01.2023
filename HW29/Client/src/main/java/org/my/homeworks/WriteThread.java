package org.my.homeworks;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class WriteThread extends Thread {
    private final Socket socket;

    public WriteThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner scanner = new Scanner(System.in);

            String userInput;
            while ((userInput = scanner.nextLine()) != null) {
                out.println(userInput);

                if ("-exit".equals(userInput)) {
                    break;
                } else if (userInput.startsWith("-file")) {
                    String filePath = userInput.substring("-file".length()).trim();
                    sendFile(filePath);
                }
            }

            out.close();
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendFile(String filePath) throws IOException {
        try (BufferedInputStream bis = new BufferedInputStream(System.in);
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
