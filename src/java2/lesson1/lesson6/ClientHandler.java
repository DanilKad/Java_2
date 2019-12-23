package java2.lesson1.lesson6;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler implements Runnable {
    private Socket socket;
    private PrintWriter out;
    private Scanner in;
    private String name;


    public ClientHandler(Socket socket) {
        try {
            this.socket = socket;
            out = new PrintWriter(socket.getOutputStream());
            in = new Scanner(socket.getInputStream());
            name = "Клиент";
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            if (in.hasNext()) {
                String w = in.nextLine();
                System.out.println(name + ": " + w);
                out.println("echo: " + w);
                out.flush();
                if (w.equalsIgnoreCase("END")) break;
            }
        }
        try{
            System.out.println("Клиент отключен");
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}