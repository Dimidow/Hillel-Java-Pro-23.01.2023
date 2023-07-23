package org.my.homeworks;

import java.io.IOException;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;
import org.my.homeworks.handlers.HttpOrderHandler;
import org.my.homeworks.repository.OrderRepository;

public class Main {

    static int SERVER_PORT = 8080;

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(SERVER_PORT), 0);
        server.createContext("/", new HttpOrderHandler(new OrderRepository()));
        server.setExecutor(null);
        server.start();
    }
}
