package org.alksndrstjc.server;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

public class CustomHttpServer {

    public static void setUpServer() {
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

            server.createContext("/limited", exchange -> {
                if ("GET".equals(exchange.getRequestMethod())) {
                    OutputStream responseBody = exchange.getResponseBody();
                    String message = "Hello from limited!";
                    exchange.sendResponseHeaders(200, message.length());
                    responseBody.write(message.getBytes(StandardCharsets.UTF_8));
                    responseBody.close();
                }
            });

            server.createContext("/unlimited", exchange -> {
                if ("GET".equals(exchange.getRequestMethod())) {
                    OutputStream responseBody = exchange.getResponseBody();
                    String message = "Hello from unlimited!";
                    exchange.sendResponseHeaders(200, message.length());
                    responseBody.write(message.getBytes(StandardCharsets.UTF_8));
                    responseBody.close();
                }
            });

            server.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
