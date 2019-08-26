package sockets.chat.blocking;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

class ChatServer {

    public static void main(String[] argv) throws Exception {
        String clientMsg;
        ServerSocket welcomeSocket = new ServerSocket(7890);
        Scanner input = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
        String horaAtual = sdf.format(new Date());

        while (true) {
            Socket connectionSocket = welcomeSocket.accept();
            DataInputStream in;
            DataOutputStream out;
            in = new DataInputStream(connectionSocket.getInputStream());
            out = new DataOutputStream(connectionSocket.getOutputStream());

            clientMsg = in.readUTF();
            System.out.println(clientMsg);

            System.out.print("Servidor (" + horaAtual + "): ");
            String serverMsg = input.nextLine();
            out.writeUTF("Servidor (" + horaAtual + "): " + serverMsg);

        }
    }
}
