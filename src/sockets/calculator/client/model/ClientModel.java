package sockets.calculator.client.model;

public class ClientModel {
    private ServerModel server;

    public ClientModel(String addr, int port) {
        this.server = new ServerModel(addr, port);
    }

    public ServerModel getServer() {
        return server;
    }

    public void setServer(ServerModel server) {
        this.server = server;
    }
}
