import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    static void connection(int port) {
        String name;
        String answer;
        ServerSocket serverSocket;

        try {
            serverSocket = new ServerSocket(port);
            Socket clientSocket = serverSocket.accept();
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            System.out.println("New connection accepted");
            out.println("Фамилия");
            name = in.readLine();
            out.println("Желаете освоить новую профессию (Да/Нет)?");
            answer = in.readLine();
            while (true) {
                if (answer.equalsIgnoreCase("Да")) {
                    out.println("Предлагаем попробовать себя в IT-сфере" + name);
                    out.println(java.util.Optional.empty());
                    break;
                } else if (answer.equalsIgnoreCase("Нет")) {
                    out.println("Подумайте и воспользуйтесь нашим предложением!" + name);
                    out.println(java.util.Optional.empty());
                    break;
                } else while (clientSocket.isConnected()) {
                    out.println("Желаете реализовать свой творческий потенциал?" + name);
                    answer = in.readLine();
                    if (answer.equalsIgnoreCase("Да")) {
                        out.println("Нетология поможет определиться с выбором" + name);
                        out.println(java.util.Optional.empty());
                        break;
                    } else if (answer.equalsIgnoreCase("Нет")) {
                        out.println("Подумайте и воспользуйтесь нашим предложением!" + name);
                        out.println(java.util.Optional.empty());
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}