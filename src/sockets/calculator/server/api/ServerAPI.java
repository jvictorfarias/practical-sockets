package sockets.calculator.server.api;

import sockets.calculator.server.controller.ServerControllerSingle;

public class ServerAPI {
    public static void main(String[] args) {
        ServerControllerSingle serverC = new ServerControllerSingle("127.0.0.1", 3333);
    }
}
