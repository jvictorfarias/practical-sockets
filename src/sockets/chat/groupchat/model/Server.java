package sockets.chat.groupchat.model;


import sockets.chat.groupchat.controller.GroupController;


import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class Server {

    public static void main(String[] args) throws IOException {
        // inicia o servidor
        new Server(12345).executa();
    }

    private int porta;
    private List<PrintStream> clients;

    private Server(int porta) {
        this.porta = porta;
        this.clients = new ArrayList<>();
    }

    private void executa() throws IOException {
        ServerSocket servidor = new ServerSocket(this.porta);
        System.out.println("Porta 12345 aberta!");

        while (true) {
            // aceita um cliente
            Socket client = servidor.accept();
            System.out.println("Nova conexão com o cliente " +
                    client.getInetAddress().getHostAddress()
            );

            // adiciona saida do cliente à lista
            PrintStream ps = new PrintStream(client.getOutputStream());
            this.clients.add(ps);

            // cria tratador de cliente numa nova thread
            GroupController tc =
                    new GroupController(client.getInputStream(), this);
            new Thread(tc).start();
        }
    }

    /* envia msg para todo mundo*/
    public void distribuiMensagem(String msg, InputStream self_client) {
        for (PrintStream cliente : this.clients) {
            cliente.println(msg);
        }
    }
}