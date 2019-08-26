package sockets.chat.groupchat.controller;

import java.io.InputStream;
import java.util.Scanner;

public class ClientController implements Runnable {

    private InputStream servidor;

    public ClientController(InputStream servidor) {
        this.servidor = servidor;
    }

    public void run() {
        // recebe msgs do servidor e imprime na tela
        Scanner s = new Scanner(this.servidor);
        while (s.hasNextLine()) {
            System.out.println(s.nextLine());
        }
    }
}