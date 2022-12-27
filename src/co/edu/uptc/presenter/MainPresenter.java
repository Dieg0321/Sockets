package co.edu.uptc.presenter;

import java.io.IOException;
import java.io.ObjectInputFilter.Status;
import java.net.Socket;
import java.util.ArrayList;
import java.awt.Color;
import co.edu.uptc.contract.MainContract;
import co.edu.uptc.contract.MainContract.Model;
import co.edu.uptc.contract.MainContract.View;
import co.edu.uptc.entity.Chat;
import co.edu.uptc.entity.Client;
import co.edu.uptc.entity.Ball;
import co.edu.uptc.models.ClientConected;
import co.edu.uptc.models.SocketManager;
import co.edu.uptc.views.MainBoard;

public class MainPresenter implements MainContract.Presenter, MainContract.Model, MainContract.View{

    SocketManager socketManager;
    MainContract.View view;
    MainContract.Model model;
    protected static MainPresenter instance = new MainPresenter();

    public MainPresenter(){
        
    }

    @Override
    public void setModel(Model model) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setView(View view) {
        this.view = view;
        
    }

    @Override
    public void startGame() {
           view = MainBoard.getInstance();
    }

    public Client createClient(Socket socket, Color color){
        return new Client(socket, color);
    }
   
    @Override
    public void setStatus(Status value) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void updateClients(ArrayList<Client> client) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void receivedChat(Chat chat) {
        MainBoard.getInstance().receivedChat(chat);
    }

    @Override
    public void receivedBall(ArrayList<Ball> balls) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void startServer(int port) {
        socketManager = new SocketManager();
        socketManager.startServer(port);
        System.out.println("Servidor corriendo: "+ socketManager.getIp());
        
    }

    @Override
    public void startClient(Client client) {
        socketManager = new SocketManager();
        socketManager.startClient(client);
        //System.out.println("Cliente conectado: " + socketManager.getClientManager().getSocket().isBound());
        
    }
    

    public Chat getChat(){
        return MainBoard.getInstance().createChat();
    }

    @Override
    public void stopClient() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void stopServer() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setPresenter(co.edu.uptc.contract.MainContract.Presenter presenter) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void write(String className, String text) {
        socketManager.write(className, text);
        
    }

    @Override
    public ArrayList<Client> getClients() {
        return null;
    }

    @Override
    public String getIp() {
        // TODO Auto-generated method stub
        return null;
    }

    public static MainPresenter getInstance(){
        return instance;
    }

    public Client createClient(String ip, int port, Color color) {
        try {
            return new Client(new Socket(ip, port), color);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.err.println("Error al crear cliente");
        }
        return null;
    }

    // public Chat createChat(){

    // }

}
