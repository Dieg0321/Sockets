package co.edu.uptc.models;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.google.gson.Gson;

import co.edu.uptc.entity.Chat;
import co.edu.uptc.entity.Server;


public class ServerManager {

    private Server socketServer;
    private String message;
    private int port;

    public ServerManager(){
        
    }

    public String getMessage(){
        return message;
    }


    public void start(int port){
        socketServer = new Server(port);
        socketServer.start();
    }

    public void setPort(int port) {
        this.port = port;
    }
    
    public Server getSocketServer(){
        return socketServer;
    }

    public Server getSocket(){
        return socketServer;
    }

    public Chat jsonToChat(){
        Gson gson = new Gson();
        return gson.fromJson(socketServer.getMessage(), Chat.class);
    }

}
