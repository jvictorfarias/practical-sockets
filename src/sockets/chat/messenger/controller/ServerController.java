package sockets.chat.messenger.controller;

import sockets.chat.messenger.model.Server;

public class ServerController implements Runnable {
    public final Server server;

    public ServerController(String addr, int port) {
        server = new Server(addr, port);
    }

    @Override
    public void run() {

    }

}
