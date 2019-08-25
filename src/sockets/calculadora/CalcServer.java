package sockets.calculadora;

import java.net.*;
import java.io.*;

public class CalcServer {
  public static void main(String args[]) {
    try {
      int serverPort = 7896;
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

  public Connection(Socket aClientSocket) {
    try {
      clientSocket = aClientSocket;
      in = new DataInputStream(clientSocket.getInputStream());
      out = new DataOutputStream(clientSocket.getOutputStream());
      this.start();
    } catch (IOException e) {
      System.out.println("Connection:" + e.getMessage());
    }
  }

  public void run() {
    try { // an echo server
      String data = in.readUTF();
      String[] newData = data.split(" ");
      for (String x : newData) {
        if (x.equals("+")) {
          out.writeInt(Integer.parseInt(newData[0]) + Integer.parseInt(newData[2]));
          break;
        } else if (x.equals("-")) {
          out.writeInt(Integer.parseInt(newData[0]) - Integer.parseInt(newData[2]));
          break;
        } else if (x.equals("*")) {
          out.writeInt((Integer.parseInt(newData[0]) * Integer.parseInt(newData[2])));
          break;
        } else if (x.equals("/")) {
          out.writeInt((Integer.parseInt(newData[0]) / Integer.parseInt(newData[2])));
        } else {
          continue;
        }
      }
    } catch (EOFException e) {
      System.out.println("EOF:" + e.getMessage());
    } catch (IOException e) {
      System.out.println("IO:" + e.getMessage());
    } finally {
      try {
        clientSocket.close();
      } catch (IOException e) {
        /* close failed */}
    }
  }
}