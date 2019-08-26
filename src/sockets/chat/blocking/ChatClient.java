package sockets.chat.blocking;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ChatClient {

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
        String horaAtual = sdf.format(new Date());
        Scanner input = new Scanner(System.in);
        Socket s = null;
        while (true) {
            try {
                int serverPort = 7890;
                s = new Socket("localhost", serverPort);
                DataInputStream in = new DataInputStream(s.getInputStream());
                DataOutputStream out = new DataOutputStream(s.getOutputStream());

                System.out.print("Cliente (" + horaAtual + "): ");
                String mensagem = input.nextLine();
                out.writeUTF("Cliente (" + horaAtual + "): " + mensagem);

                String data = in.readUTF();
                System.out.println(data);
            } catch (UnknownHostException e) {
                System.out.println("Sock:" + e.getMessage());
            } catch (EOFException e) {
                System.out.println("EOF:" + e.getMessage());
            } catch (IOException e) {
                System.out.println("IO:" + e.getMessage());
            }
        }
    }
}
