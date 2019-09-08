package sockets.calculator.server.controller;


import sockets.calculator.server.connection.ServerConnectionMulti;
import sockets.calculator.server.model.ServerModel;

import java.io.IOException;
import java.net.ServerSocket;

public class ServerController {
    private ServerModel server;
    private ServerSocket listenSocket;

    public ServerController(String addr, int port) {
        this.server = new ServerModel(addr, port);
        callServer();
    }

    private void callServer() {
        try {
            this.setListenSocket(new ServerSocket(this.getServer().getPort()));
            //noinspection InfiniteLoopStatement
            while (true) {
                new ServerConnectionMulti(this.getListenSocket().accept());
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

    public ServerModel getServer() {
        return server;
    }

    public void setServer(ServerModel server) {
        this.server = server;
    }
}
