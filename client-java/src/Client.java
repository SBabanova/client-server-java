import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) {
        System.out.println("Hello, I'm a client!");

        int serverPort = 2018;
        String strServerIP = "";
        String strClientIP = "";

        try {
            InetAddress serverIP = InetAddress.getByName(strServerIP);
            InetAddress clientIP = InetAddress.getByName(strClientIP);
            Socket socket = new Socket(serverIP, serverPort);

            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
