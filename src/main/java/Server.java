import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {

    public static void main(String[] args) {

        ServerSocket serverSocket;
        Socket socket ;
        DataInputStream in;
        DataOutputStream out;

        final int PUERTO = 12000;

        try {
            serverSocket = new ServerSocket(PUERTO);
            System.out.println("Servidor iniciado");

            while (true) {
                socket = serverSocket.accept();

                System.out.println("Cliente conectado");

                in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());

                String mensaje = in.readUTF();

                System.out.println("MENSAJE CLIENTE: " + mensaje);

                out.writeUTF("Respuesta del servidor");
                socket.close();

                System.out.println("Cliente desconectado");
                System.out.println("--------------------------------");
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}