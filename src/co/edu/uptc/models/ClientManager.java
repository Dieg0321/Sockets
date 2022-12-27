package co.edu.uptc.models;

//import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

import co.edu.uptc.contract.MainContract;
import co.edu.uptc.entity.Chat;
import co.edu.uptc.entity.Client;
import co.edu.uptc.views.MainBoard;

public class ClientManager {
    
    private Socket socket;

    // private ArrayList<ClientConected> clientsConected;
    private ClientConected clientConected;
    private Client client;
    //private Chat chat;

    public ClientManager(){

    }

    // public ArrayList<ClientConected> getClientConected() {
    //     return clientsConected;
    // }

    // public void setClientConected(ArrayList<ClientConected> clientConected) {
    //     this.clientsConected = clientConected;
    // }

    public Socket getSocket() {
        return socket;
    }

    public void start(Client client){
        clientConected = new ClientConected(client);
        clientConected.write(MainBoard.getInstance().createChat());
    }

    // public Chat getChat(){
    //     return chat;
    // }

    // public void setChat(String message){
    //     this.chat = new Chat(chat.getIp(), message);
    // }
    
}
