package sockets.chat.groupchat.model;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args){
        try {
            Socket client = new Socket("127.0.0.1", 3000);
            PrintStream out = new PrintStream(client.getOutputStream());

            Scanner scan = new Scanner(System.in);
            while(scan.hasNextLine()){
                out.println(scan.nextLine());
            }
        }catch (IOException e){
            System.out.println("Socket creation failed.");
        }




    }
}
