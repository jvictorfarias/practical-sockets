package sockets.chat.messenger.model;

import java.io.Serializable;

public class User implements Serializable {
    private String nome;
    private String serverAddr;
    private int serverPort;
    private long id;


    public User(String nome, String serverAddr, int serverPort) {
        this.nome = nome;
        this.serverAddr = serverAddr;
        this.serverPort = serverPort;
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

    public String getServerAddr() {
        return serverAddr;
    }

    public void setServerAddr(String serverAddr) {
        this.serverAddr = serverAddr;
    }

    public int getServerPort() {
        return serverPort;
    }

    public void setServerPort(int serverPort) {
        this.serverPort = serverPort;
    }
}
