package sockets.chat.messenger.frontend.model;

import sockets.chat.messenger.backend.model.Server;

import java.io.Serializable;

public class User {
    private String nome;
    private Server server;


    public User(String nome, String serverAddr, int serverPort) {
        this.nome = nome;
        server = new Server(serverAddr, serverPort);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }
}
