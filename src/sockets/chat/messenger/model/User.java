package sockets.chat.messenger.model;

import java.io.Serializable;

public class User implements Serializable {
    private String nome;
    private Server server;
    private long id;


    public User(String nome, String serverAddr, int serverPort) {
        this.nome = nome;
        server = new Server(serverAddr, serverPort);
        //this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }
}
