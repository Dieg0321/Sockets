package co.edu.uptc.models;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import co.edu.uptc.entity.Chat;
import co.edu.uptc.entity.Client;

public class ClientConected implements Runnable{

    private Chat chat;
    private Socket socket;
    private Client client;
    
    public ClientConected(Client client){
        this.client = client;
        socket = client.getSocket();

        //this.socket = socket;
    }

    public String getIp(){
        return chat.getIp();
    }

    @Override
    public void run() {
        
    }

    public void write(Chat chat){
        Thread writeThread = new Thread();
            this.chat = chat;
            try {
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                dos.writeUTF(this.chat.chatToJson());
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
    }

    public void start(){
        Thread clientThread = new Thread(this);
        clientThread.start();
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

}
