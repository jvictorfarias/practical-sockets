package assets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

class TCPServerSingleThread {
	public static void main(String argv[]) throws Exception {
		String clientSentence;
		String capitalizedSentence;
		ServerSocket welcomeSocket = new ServerSocket(6789);

		while (true) {
			Socket connectionSocket = welcomeSocket.accept();

			/*
			 * System.out.println("Conexao aceita. \nPorta Cliente Remoto: " +
			 * connectionSocket.getPort() + "\nPorta Local: " +
			 * connectionSocket.getLocalPort());
			 */

			DataInputStream in;
			DataOutputStream out;

			in = new DataInputStream(connectionSocket.getInputStream());
			out = new DataOutputStream(connectionSocket.getOutputStream());

			clientSentence = in.readUTF();
			// System.out.println("processando...");
			// Thread.sleep((int) (Math.random() * 1000));
			Thread.sleep(100);
			// System.out.println("processamento finalizado");
			capitalizedSentence = clientSentence.toUpperCase() + '\n';
			out.writeUTF(capitalizedSentence);
		}
	}
}