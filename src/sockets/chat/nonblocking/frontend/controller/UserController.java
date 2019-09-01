package sockets.chat.nonblocking.frontend.controller;

import sockets.chat.nonblocking.frontend.model.User;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class UserController {
    private User user;
    private Socket socket = null;
    private DataInputStream in;
    private DataOutputStream out;

    public UserController(String nome, String addr, int port) throws IOException {
        this.user = new User(nome, addr, port);
        this.socket = new Socket(user.getServer().getAddr(), user.getServer().getPort());
        this.in = new DataInputStream(socket.getInputStream());
        this.out = new DataOutputStream(socket.getOutputStream());
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public DataInputStream getIn() {
        return in;
    }

    public void setIn(DataInputStream in) {
        this.in = in;
    }

    public DataOutputStream getOut() {
        return out;
    }

    public void setOut(DataOutputStream out) {
        this.out = out;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
