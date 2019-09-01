package sockets.chat.nonblocking.backend.view;

import sockets.chat.nonblocking.backend.controller.ServerController;


import java.io.IOException;

public class ServerView {

    public static void main(String[] args) throws IOException {
        ServerController server = new ServerController("127.0.0.1", 3333);
    }
}
