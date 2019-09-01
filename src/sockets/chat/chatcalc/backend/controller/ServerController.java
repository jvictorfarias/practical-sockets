package sockets.chat.chatcalc.backend.controller;


import sockets.chat.chatcalc.backend.connection.ServerConnection;
import sockets.chat.chatcalc.backend.model.Server;

import java.io.IOException;
import java.net.ServerSocket;

public class ServerController {
    private Server server;
    private ServerSocket listenSocket;

    public ServerController(String addr, int port) {
        this.server = new Server(addr, port);
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
