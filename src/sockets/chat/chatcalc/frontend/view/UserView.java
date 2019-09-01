package sockets.chat.chatcalc.frontend.view;

import sockets.chat.chatcalc.frontend.connection.UserConnection;

import java.io.IOException;
import java.util.Scanner;

public class UserView extends Thread {
    public static void main(String[] args) throws IOException {
        System.out.print("Tell your username: ");
        Scanner scan = new Scanner(System.in);
        String teste = scan.nextLine().toUpperCase();
        UserConnection user = new UserConnection(teste);

    }
}
