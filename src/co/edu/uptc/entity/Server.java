package co.edu.uptc.entity;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable{

    private ServerSocket server;
    private Socket socket;
    private String message;
    //private int port;

    public Server(int port){
        createServer(port);
    }

    public void createServer(int port){
        try {
            server = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start(){
        Thread serverThread = new Thread(this);
        serverThread.start();
    }


    @Override
    public void run() {
        while(true){
            DataInputStream dis;
            try {
                socket = server.accept();
                dis = new DataInputStream(socket.getInputStream());
                message = dis.readUTF();
                dis.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                System.err.println("Error al leer");
            }
        }
    }

    public ServerSocket getServer() {
        return server;
    }

    public void setServer(ServerSocket server) {
        this.server = server;
    }

    public String getMessage(){
        return message;
    }
    
}
