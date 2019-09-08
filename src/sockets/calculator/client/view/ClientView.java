package sockets.calculator.client.view;

import sockets.calculator.client.controller.ClientController;

import java.io.IOException;
import java.util.ArrayList;

public class ClientView {
    public static void main(String[] args) throws IOException {
        ArrayList<ClientController> clients = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            clients.add(new ClientController("127.0.0.1", 3333));
        }
    }
}
