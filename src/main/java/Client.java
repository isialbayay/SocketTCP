import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client{

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        final String HOST = "127.0.0.1";
        final int PUERTO = 12000;

        DataInputStream in;
        DataOutputStream out;

        try {

            Socket socket = new Socket(HOST, PUERTO);

            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            System.out.println("Escriba su mensaje al servidor");
            out.writeUTF(scanner.nextLine());


            String mensaje = in.readUTF();
            System.out.println(mensaje);

            socket.close();

        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}

