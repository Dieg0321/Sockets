package co.edu.uptc.presenter;

import java.io.ObjectInputFilter.Status;
import java.util.ArrayList;
import java.awt.Color;
import co.edu.uptc.contract.MainContract;
import co.edu.uptc.contract.MainContract.Model;
import co.edu.uptc.contract.MainContract.View;
import co.edu.uptc.models.Ball;
import co.edu.uptc.models.Chat;
import co.edu.uptc.models.Client;
import co.edu.uptc.models.SocketManager;
import co.edu.uptc.views.MainBoard;

public class MainPresenter implements MainContract.Presenter, MainContract.Model, MainContract.View{

    SocketManager socketManager;
    MainContract.View view;
    MainContract.Model model;
    public static MainPresenter instance = new MainPresenter();


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

    public Client createClient(String ip, int port, Color color){
        return new Client(ip, port, color);
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
        
    }

    @Override
    public void receivedBall(ArrayList<Ball> balls) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void startServer(int port) {
        socketManager = new SocketManager();
        socketManager.startServer(port);
        System.out.println("Servidor corriendo: "+ socketManager.getServerManager().getServerSocket().isBound());
        
    }

    @Override
    public void startClient(Client client) {
        socketManager = new SocketManager();
        socketManager.startClient(client);
        System.out.println("Cliente conectado: " + socketManager.getClientManager().getSocket().isBound());
        System.out.println(client.toJson());
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
        // TODO Auto-generated method stub
        
    }

    @Override
    public ArrayList<Client> getClients() {
        // TODO Auto-generated method stub
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
    
}
