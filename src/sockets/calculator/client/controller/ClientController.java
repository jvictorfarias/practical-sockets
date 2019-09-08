package sockets.calculator.client.controller;

import sockets.calculator.client.connection.ClientConnection;
import sockets.calculator.client.model.ClientModel;

import java.io.IOException;
import java.net.Socket;

public class ClientController {
    private ClientModel client;
    private ClientConnection connection;
    private Socket clientSocket;

    public ClientController(String addr, int port) throws IOException {
        this.client = new ClientModel(addr, port);
        this.clientSocket = new Socket(this.client.getServer().getAddr(), this.client.getServer().getPort());
        this.connection = new ClientConnection(clientSocket);
    }

    public ClientModel getClient() {
        return client;
    }

    public void setClient(ClientModel client) {
        this.client = client;
    }

    public ClientConnection getConnection() {
        return connection;
    }

    public void setConnection(ClientConnection connection) {
        this.connection = connection;
    }

    public Socket getClientSocket() {
        return clientSocket;
    }

    public void setClientSocket(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }
}
