package sockets.chat.groupchat.controller;

import sockets.chat.groupchat.model.Client;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Server {
    public static void main(String[] args)  throws IOException {
        ServerSocket server = new ServerSocket(3000);

        Socket client = server.accept();
        System.out.println("Cliente: "+
                client.getInetAddress().getHostAddress()
        );
        Scanner scan = new Scanner(client.getInputStream());
        while (scan.hasNextLine()){
            System.out.println(scan.nextLine());
            System.out.println(client.toString());
        }

        scan.close();
        client.close();
        server.close();
    }
}
