package sockets.chat.groupchat.controller;

import java.io.InputStream;
import java.util.Scanner;

public class ClientController implements Runnable {

    private InputStream server;

    public ClientController(InputStream server) {
        this.server = server;
    }

    public void run() {
        // recebe msgs do servidor e imprime na tela
        Scanner s = new Scanner(this.server);
        while (s.hasNextLine()) {
            System.out.println(s.nextLine());
        }
    }
}