package org.my.homeworks.handlers;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.my.homeworks.repository.OrderRepository;

public class HttpOrderHandler implements HttpHandler {

    private final OrderRepository orderRepository;

    public HttpOrderHandler(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        URI uri = exchange.getRequestURI();
        String path = uri.getPath();
        if (path.startsWith("/order/")) {
            int id = getId(uri);
            sendResponse(exchange, orderRepository.getOrderById(id).toString());
        } else if (path.equals("/orders")) {
            sendResponse(exchange, orderRepository.getAllOrders().toString());
        } else {
            sendResponse(exchange, "Incorrect route");
        }
    }

    private Integer getId(URI uri) {
        String path = uri.getPath();
        String[] parts = path.split("/");
        return Integer.parseInt(parts[parts.length - 1]);
    }

    private void sendResponse(HttpExchange exchange, String response) throws IOException {
        exchange.sendResponseHeaders(200, response.getBytes().length);
        OutputStream output = exchange.getResponseBody();
        output.write(response.getBytes());
        output.flush();
        exchange.close();
    }
}
