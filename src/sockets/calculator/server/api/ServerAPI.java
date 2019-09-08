package sockets.calculator.server.api;

import sockets.calculator.server.controller.ServerControllerMulti;

public class ServerAPI {
    public static void main(String[] args) {
        ServerControllerMulti serverC = new ServerControllerMulti("127.0.0.1", 3333);
    }
}
