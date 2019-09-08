package sockets.calculator.client.view;

import sockets.calculator.client.controller.ClientController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class ClientView {
    public static void main(String[] args) throws IOException, InterruptedException {
        long startTime = new Date().getTime();
        ArrayList<ClientController> clients = new ArrayList<>();
        String request = "";
        for (int i = 0; i < 200; i++) {
            request = "ADD;10;11; REQUEST: " + i;
            clients.add(new ClientController("127.0.0.1", 3333, request));
        }

        for (int i = 0; i < 200; i++) {
            clients.get(i).getConnection().join();
        }

        long endTime = new Date().getTime();
        long timeElapsed = endTime - startTime;
        System.out.println("Execution had a duration of " + timeElapsed);
    }
}
