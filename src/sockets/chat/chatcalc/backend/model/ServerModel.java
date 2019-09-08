package sockets.chat.chatcalc.backend.model;

import java.io.Serializable;

public class ServerModel implements Serializable {
    private String addr;
    private int port;

    public ServerModel(String addr, int port) {
        this.addr = addr;
        this.port = port;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
