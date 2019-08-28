package sockets.chat.messenger.backend.connection;

import java.awt.*;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ServerConnection extends Thread {
    private DataInputStream in;
    private DataOutputStream out;
    private Socket clientSocket;
    private ArrayList<OutputStream> comms = new ArrayList<>();

    public ServerConnection(Socket newClientSocket) {
        try {
            this.clientSocket = newClientSocket;
            this.in = new DataInputStream(clientSocket.getInputStream());
            this.out = new DataOutputStream(clientSocket.getOutputStream());
            this.comms.add(out);
            this.start();
        } catch (IOException e) {
            System.out.println("Connection:" + e.getMessage());
        }
    }

    public void run() {
        while (clientSocket != null) {
            try {
                String data = this.in.readUTF();
                System.out.println(data);
                this.out.writeUTF("oi");
            } catch (EOFException e) {
                System.out.println("EOF:" + e.getMessage());
            } catch (IOException e) {
                System.out.println("IO:" + e.getMessage());
            }

        }
        try {
            assert false;
            clientSocket.close();
        } catch (IOException ignored) {
        }
    }
}
