package com.mahendra.demo2;

import java.io.IOException;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;

/**
 * Hello world!
 *
 */
public class App {

    private static final URI BASE_URI = URI.create("http://localhost:9000/");

    public static final String ROOT_PATH = "hello";

    public static void main(String[] args) {
        try {
            System.out.println("JAXRS Demo Using Jersey Framework");

            final HttpServer server = GrizzlyHttpServerFactory.createHttpServer(BASE_URI, new MyApplication(), false);
            Runtime.getRuntime().addShutdownHook(new Thread(server::shutdownNow));
            server.start();

            System.out.println(String.format(
                    "Application started.\n"
                            + "Try out %s%s\n"
                            + "Stop the application using CTRL+C",
                    BASE_URI, ROOT_PATH));

            Thread.currentThread().join();
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}