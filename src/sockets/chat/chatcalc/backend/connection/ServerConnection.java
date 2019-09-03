package sockets.chat.chatcalc.backend.connection;

import sockets.chat.chatcalc.backend.controller.CalcController;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;


public class ServerConnection extends Thread {
    private DataInputStream in;
    private DataOutputStream out;
    private CalcController calcController;
    private Socket clientSocket;
    private static ArrayList<DataOutputStream> comms = new ArrayList<>();

    public ServerConnection(Socket newClientSocket) {
        try {
            this.clientSocket = newClientSocket;
            this.in = new DataInputStream(clientSocket.getInputStream());
            this.out = new DataOutputStream(clientSocket.getOutputStream());
            comms.add(out);
            this.start();
        } catch (IOException e) {
            System.out.println("Connection:" + e.getMessage());
        }
    }

    public void run() {

        while (true) {
            try {
                String data = this.in.readUTF();
                String username = data.split(":")[0];
                data = data.split(":")[1];
                if (data.startsWith("$")) {
                    data = data.replaceAll("\\$", "");
                    System.out.println("Received: " + data);
                    calcController = new CalcController();
                    double result = calcController.calcula(data);
                    boolean divZero = false;
                    if (result == Double.POSITIVE_INFINITY) {
                        divZero = true;
                    }
                    if (divZero == true) {
                        System.out.println(username + ": " + data + "\nImpossível dividir por 0!");
                        for (DataOutputStream dos : comms) {
                            if (!(dos.hashCode() == this.getOut().hashCode())) {
                                dos.writeUTF(username + ": " + data + "\n" + "Server: Impossível dividir por 0!");
                            } else {
                                dos.writeUTF("Server: Impossível dividir por 0!");
                            }
                        }
                    } else {
                        System.out.println(username + ": " + data + "\n" + result);
                        for (DataOutputStream dos : comms) {
                            if (!(dos.hashCode() == this.getOut().hashCode())) {
                                dos.writeUTF(username + ": " + data + "\n" + "Server: " + result);
                            } else {
                                dos.writeUTF("Server: " + result);
                            }
                        }
                    }
                } else {
                    System.out.println(data);
                    for (DataOutputStream dos : comms) {
                        if (!(dos.hashCode() == this.getOut().hashCode())) {
                            dos.writeUTF(username + ": " + data);
                        }
                    }
                }

            } catch (EOFException e) {
                System.out.println("EOF:" + e.getMessage());
                try {
                    clientSocket.close();
                } catch (IOException io) {
                    io.printStackTrace();
                }
                break;
            } catch (IOException e) {
                System.out.println("IO:" + e.getMessage());
                try {
                    clientSocket.close();
                } catch (IOException io) {
                    io.printStackTrace();
                }
                break;
            } catch (NullPointerException np) {
                System.out.println("NP:" + np.getMessage());
                try {
                    clientSocket.close();
                } catch (IOException io) {
                    io.printStackTrace();
                }
                break;
            }

        }

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

    public Socket getClientSocket() {
        return clientSocket;
    }

    public void setClientSocket(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public static ArrayList<DataOutputStream> getComms() {
        return comms;
    }

    public static void setComms(ArrayList<DataOutputStream> comms) {
        ServerConnection.comms = comms;
    }

    public CalcController getCalcController() {
        return calcController;
    }

    public void setCalcController(CalcController calcController) {
        this.calcController = calcController;
    }
}
