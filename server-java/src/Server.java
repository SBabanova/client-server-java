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

            String message;
            while (true){
                message = inputStream.readUTF();
                System.out.println("Client says: " + message + "\n");
                outputStream.writeUTF(message.toUpperCase());
                outputStream.flush();
            }
        } catch (IOException e) {
            //e.printStackTrace();
        }


    }
}
