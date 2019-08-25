package sockets.calculadora;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class CalcClient {
  public static void main(String args[]) {
    // arguments supply message and hostname of destination
    Socket s = null;
    System.out.println("Digite a operação a ser realizada: ");
    Scanner scan = new Scanner(System.in);
    String operation = scan.nextLine();
    scan.close();

    try {
      int serverPort = 7896;
      s = new Socket(args[0], serverPort);
      DataInputStream in = new DataInputStream(s.getInputStream());
      DataOutputStream out = new DataOutputStream(s.getOutputStream());
      out.writeUTF(operation); // UTF is a string encoding see Sn 4.3
      int data = in.readInt();
      System.out.println("Received: " + data);
    } catch (UnknownHostException e) {
      System.out.println("Sock:" + e.getMessage());
    } catch (EOFException e) {
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
