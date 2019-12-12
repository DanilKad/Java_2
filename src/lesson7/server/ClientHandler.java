package lesson7.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {
    private Server server;
    private Socket socket;
    DataInputStream in;
    DataOutputStream out;
    private String nick;
//    private String clientName;
//
//    private static int counter = 0;


    public ClientHandler(Server server, Socket socket) {

        try {
//            counter++;
            this.nick = "user";
            this.server = server;
            this.socket = socket;

//            System.out.println("LocalPort: "+socket.getLocalPort());
//            System.out.println("Port: "+socket.getPort());
//            System.out.println("InetAddress: "+socket.getInetAddress());
            System.out.println("RemoteSocketAddress: " + socket.getRemoteSocketAddress());

            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            new Thread(() -> {
                try {
                    //цикл авторизации
                    while (true) {
                        String str = in.readUTF();
                        if (str.startsWith("/auth ")) {
                            String[] token = str.split(" ");
//                            String[] token = str.split(" ",3);
                            String newNick = server.getAuthService()
                                    .getNicknameByLoginAndPassword(token[1], token[2]);
                            if (newNick != null) {
                                sendMsg("/authok " + newNick);
                                nick = newNick;
                                server.subscribe(this);
                                System.out.println("Клиент " + nick + " подключился");
                                break;
                            } else {
                                sendMsg("Неверный логин / пароль");
                            }
                        }

                    }
                    // цикл работы
                    while (true) {
                        String str = in.readUTF();
                        String[] token = str.split(" ",3);
                        if (str.equals("/end")) {
                            sendMsg("/end");
                            break;
                        }
//                        System.out.println(str);
                        server.broadcastMsg(nick + " : " + str);
                        server.wisperMsg(nick , "to",  " sas" );
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    server.unsubscribe(this);
                    System.out.println("Клиент отключился");
                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getNick() {
        return this.nick;
    }
//    public String getClientName() {
//        return this.clientName;
    //}

    public void sendMsg(String msg) {
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
