package sockets.chat.nonblocking;

import java.net.*;
import java.util.Scanner;
import java.io.*;

public class ChatClient{
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);
    // arguments supply message and hostname of destination
    Socket s = null;
    try {
      int serverPort = Integer.parseInt(args[1]);
      s = new Socket(args[0], serverPort);
      DataInputStream in = new DataInputStream(s.getInputStream());
      DataOutputStream out = new DataOutputStream(s.getOutputStream());
      while (true) {
        String msg = scan.nextLine();
        out.writeUTF(msg);
        String data = in.readUTF();
      }

    } catch (UnknownHostException e) {
      System.out.println("Sock:" + e.getMessage()); } catch (EOFException e) {
      System.out.println("EOF:" + e.getMessage());
    } catch (IOException e) {
      System.out.println("IO:" + e.getMessage());
    } finally {
      if (s != null) {
        try {
          s.close();
        } catch (IOException e) {
          System.out.println("close:" + e.getMessage());
        }
      }
    }
  }
}
