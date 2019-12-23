package java2.lesson1.lesson6;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {

        ServerSocket server = null;
        Socket socket = null;


        try {
            server = new ServerSocket(9189);
            System.out.println("Сервер запущен");

            while (true) {
                socket = server.accept();
                System.out.println("Клиент онлайн");
                new Thread(new ClientHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
                server.close();
                System.out.println("Сервер закрыт");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
