package sockets.chat.nonblocking;

import java.net.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.io.*;

public class ChatServer {
  public static void main(String args[]) {
    try {
      int serverPort = Integer.parseInt(args[0]);
      ServerSocket listenSocket = new ServerSocket(serverPort);

      while (true) {
        Socket clientSocket = listenSocket.accept();
        Connection c = new Connection(clientSocket);
      }
    } catch (IOException e) {
      System.out.println("Listen :" + e.getMessage());
    }
  }
}

class Connection extends Thread {
  DataInputStream in;
  DataOutputStream out;
  Socket clientSocket;
  ArrayList<Connection> clients = new ArrayList<>();
  Date date;

  public Connection(Socket aClientSocket) {
    try {
      clientSocket = aClientSocket;
      in = new DataInputStream(clientSocket.getInputStream());
      out = new DataOutputStream(clientSocket.getOutputStream());
      clients.add(this);
      this.start();
    } catch (IOException e) {
      System.out.println("Connection:" + e.getMessage());
    }
  }

  public void run() {
    while (true) {
      try { // an echo server
        String data = in.readUTF();
        String timeStamp = new SimpleDateFormat("HH.mm.ss").format(new java.util.Date());
        System.out.println(timeStamp + ": " + data);
        for (Connection x : this.clients) {
          x.out.writeUTF(data);
          // DataOutputStream general = new DataOutputStream(x.getOutputStream());
          // general.writeUTF(data);
          // System.out.println(data);
        }
      } catch (EOFException e) {
        System.out.println("EOF:" + e.getMessage());
      } catch (IOException e) {
        System.out.println("IO:" + e.getMessage());
      }
    }
  }

}