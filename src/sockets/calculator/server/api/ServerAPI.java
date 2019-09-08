package sockets.calculator.server.api;

import sockets.calculator.server.controller.ServerController;

public class ServerAPI {
    public static void main(String[] args) {
        ServerController serverC = new ServerController("127.0.0.1", 3333);
    }
}
