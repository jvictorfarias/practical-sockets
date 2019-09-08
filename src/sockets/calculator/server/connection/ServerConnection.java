package sockets.calculator.server.connection;

import sockets.chat.chatcalc.backend.controller.CalcController;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class ServerConnection extends Thread {
    private DataInputStream in;
    private DataOutputStream out;
    private Socket clientSocket;
    private CalcController calculator;

    public ServerConnection(Socket newClientSocket) {
        try {
            this.clientSocket = newClientSocket;
            this.calculator = new CalcController();
            this.in = new DataInputStream(clientSocket.getInputStream());
            this.out = new DataOutputStream(clientSocket.getOutputStream());
            this.start();
        } catch (IOException e) {
            System.out.println("Connection:" + e.getMessage());
        }
    }

    private void sendResponse(String request) throws IOException {
        this.out.writeUTF(request);
    }

    private String getRequest() throws IOException {
        return this.in.readUTF();
    }

    public void run() {

        //noinspection InfiniteLoopStatement
        while (true) {
            try {
                sendResponse(String.valueOf(calculator.calcula(getRequest())));
            } catch (EOFException e) {
                System.out.println("EOF:" + e.getMessage());
            } catch (IOException e) {
                System.out.println("IO:" + e.getMessage());
            } catch (NullPointerException np) {
                try {
                    clientSocket.close();
                } catch (IOException ignored) {
                }
            }

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

    public Socket getClientSocket() {
        return clientSocket;
    }

    public void setClientSocket(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

}
