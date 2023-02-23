package edu.escuelaing.arem.microspring;

import edu.escuelaing.arem.server.HttpServer;

public class MicroSpringBoot {
    public static void main(String[] args) {
        UriProcessor uriProcessor = new MicroSpring();
        try {
            uriProcessor.start(args[0]);
        } catch (Exception e) {
            // Nothing to do
        }

        HttpServer server = HttpServer.getInstance();
        server.run(uriProcessor);
    }
}
