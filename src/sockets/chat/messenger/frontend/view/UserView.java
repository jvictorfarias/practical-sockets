package sockets.chat.messenger.frontend.view;

import sockets.chat.messenger.frontend.controller.UserController;

import java.io.IOException;
import java.util.Scanner;

public class UserView {
    public static void main(String[] args) throws IOException {
        UserController user = new UserController("Joao", "127.0.0.1", 3333);
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()) {
            String send = scan.nextLine();
            user.getOut().writeUTF(send);
            System.out.println(user.getIn().readUTF());
        }

    }

}
