import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(8080)) {

            Socket socket = serverSocket.accept();

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            System.out.println("New connection accepted");

            final String message = in.readLine();
            out.println(String.format("Hi %s, your port is %d", message, socket.getPort()));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
