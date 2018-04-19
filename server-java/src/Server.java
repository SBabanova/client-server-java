import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

//    final int PORT = 2018;
//    ServerSocket serverSocket;
//    Socket socket;

    public static void main(String[] args) {
        System.out.println("Hello, I'm a server!");

        final int serverPort = 2018;
        ServerSocket serverSocket;
        Socket socket;

        try {
            serverSocket = new ServerSocket(serverPort);
            socket = serverSocket.accept();
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

            String packet;
            while (true){
                packet = inputStream.readUTF();
                System.out.println(packet + "\n");
                outputStream.writeUTF(packet + " 1");
                outputStream.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
