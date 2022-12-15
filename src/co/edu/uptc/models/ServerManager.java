package co.edu.uptc.models;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerManager implements Runnable{

    private ServerSocket server;
    private Socket socket;
    private String message;
    private int port;

    public ServerManager(){
    
    }

    public String getMessage(){
        return message;
    }

    public void createSocket(int port){
        this.port = port;
        try {
            server = new ServerSocket(this.port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            socket = server.accept();
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            
            //message = dis.readUTF();
            dis.close();
            socket.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start(){
        Thread serverThread = new Thread(this);
        serverThread.start();
    }

    public void setPort(int port) {
        this.port = port;
    }
    
    public ServerSocket getServerSocket(){
        return server;
    }

    public Socket getSocket(){
        return socket;
    }

}
