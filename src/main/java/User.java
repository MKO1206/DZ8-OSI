import java.io.*;
import java.net.Socket;

public class User {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 808);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                out.println("Client");
                String resp = in.readLine();
                System.out.println(resp);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
