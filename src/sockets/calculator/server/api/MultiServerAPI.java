package sockets.calculator.server.api;

import sockets.calculator.server.controller.ServerControllerMulti;

public class MultiServerAPI {
    public static void main(String[] args) {
        new ServerControllerMulti("127.0.0.1", 3333);
    }
}
