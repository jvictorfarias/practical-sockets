package sockets.chat.groupchat.model;

import sockets.chat.groupchat.controller.ClientController;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args)
            throws UnknownHostException, IOException {
        // dispara cliente
        new Client("127.0.0.1", 3333).executa();
    }

    private String host;
    private int porta;

    private Client(String host, int porta) {
        this.host = host;
        this.porta = porta;
    }

    private void executa() throws IOException {
        Socket cliente = new Socket(this.host, this.porta);
        System.out.println("O cliente se conectou ao servidor!");

        // thread para receber mensagens do servidor
        ClientController r = new ClientController(cliente.getInputStream());
        new Thread(r).start();

        // lê msgs do teclado e manda pro servidor
        Scanner teclado = new Scanner(System.in);
        PrintStream saida = new PrintStream(cliente.getOutputStream());
        while (teclado.hasNextLine()) {
            saida.println(teclado.nextLine());
        }

        saida.close();
        teclado.close();
        cliente.close();
    }
}
