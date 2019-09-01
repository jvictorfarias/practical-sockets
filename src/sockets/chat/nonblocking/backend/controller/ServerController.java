package sockets.chat.nonblocking.backend.controller;


import sockets.chat.nonblocking.backend.connection.ServerConnection;
import sockets.chat.nonblocking.backend.model.Server;

import java.io.IOException;
import java.net.ServerSocket;

public class ServerController {
    private Server server;
    private ServerSocket listenSocket;

    public ServerController(String addr, int port) {
        server = new Server(addr, port);
        callServer();
    }

    private void callServer() {
        try {
            this.setListenSocket(new ServerSocket(this.getServer().getPort()));
            //noinspection InfiniteLoopStatement
            while (true) {
                new ServerConnection(this.getListenSocket().accept());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    private ServerSocket getListenSocket() {
        return listenSocket;
    }

    private void setListenSocket(ServerSocket listenSocket) {
        this.listenSocket = listenSocket;
    }

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }
}
