package sockets.calculator.server.api;

import sockets.calculator.server.controller.ServerControllerMulti;
import sockets.calculator.server.controller.ServerControllerSingle;

public class MultiServerAPI {
    public static void main(String[] args) {
        ServerControllerMulti serverMulti = new ServerControllerMulti("127.0.0.1", 3333);
    }
}
