package sockets.calculator.client.connection;

import sockets.calculator.client.controller.ClientController;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientConnection extends Thread {
    private DataInputStream in;
    private DataOutputStream out;
    private Socket client;

    public ClientConnection(Socket client) throws IOException {
        this.client = client;
        this.in = new DataInputStream(this.client.getInputStream());
        this.out = new DataOutputStream(this.client.getOutputStream());
        this.start();
    }

    private void sendRequest(String request) throws IOException {
        this.getOut().writeUTF(request);
    }

    private String getResponse() throws IOException {
        return this.getIn().readUTF();
    }

    private void close() throws IOException {
        this.getClient().close();
    }

    public void run() {
        try {
            this.sendRequest("ADD;10;11");
            System.out.println(this.getResponse());
            this.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public DataInputStream getIn() {
        return in;
    }

    public void setIn(DataInputStream in) {
        this.in = in;
    }

    public DataOutputStream getOut() {
        return out;
    }

    public void setOut(DataOutputStream out) {
        this.out = out;
    }

    private Socket getClient() {
        return client;
    }

    public void setClient(Socket client) {
        this.client = client;
    }
}
