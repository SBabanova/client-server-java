import java.io.*;
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

            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String message;
            while (true){
                message = bufferedReader.readLine();
                System.out.println(message);
                outputStream.writeUTF(message);
                outputStream.flush();
                message = inputStream.readUTF();
                System.out.println("Server's answer: " + message + "\n");
            }
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Server isn't available");
        }

    }
}
