package sockets.calculator.server.api;

import sockets.calculator.server.controller.ServerControllerSingle;

public class SingleServerAPI {
    public static void main(String[] args) {
        ServerControllerSingle singleServer = new ServerControllerSingle("127.0.0.1", 3333);
    }
}
