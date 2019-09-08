package sockets.chat.chatcalc.frontend.model;

import sockets.chat.chatcalc.backend.model.ServerModel;

public class User {
    private String nome;
    private ServerModel server;


    public User(String nome, String serverAddr, int serverPort) {
        this.nome = nome;
        server = new ServerModel(serverAddr, serverPort);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ServerModel getServer() {
        return server;
    }

    public void setServer(ServerModel server) {
        this.server = server;
    }
}
