package sockets.chat.groupchat.controller;

import sockets.chat.groupchat.model.Server;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class GroupController implements Runnable {

    private InputStream client;
    private Server server;

    public GroupController(InputStream client, Server server) {
        this.client = client;
        this.server = server;
    }

    public void run() {
        // quando chegar uma msg, distribui pra todos
        Scanner s = new Scanner(this.client);
        while (s.hasNextLine()) {
            server.distribuiMensagem(s.nextLine(), this.client);
        }
        s.close();
    }
}