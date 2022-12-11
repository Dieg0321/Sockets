package co.edu.uptc.views;

import java.io.ObjectInputFilter.Status;
import java.util.ArrayList;

import javax.swing.JFrame;
import co.edu.uptc.contract.MainContract;
import co.edu.uptc.contract.MainContract.Presenter;
import co.edu.uptc.models.Ball;
import co.edu.uptc.models.Chat;
import co.edu.uptc.models.Client;

public class MainBoard extends JFrame implements MainContract.View {
    
    private static MainBoard instance;


    public MainBoard getInstance(){
        return instance;
    }


    @Override
    public void setPresenter(Presenter presenter) {
        // TODO Auto-generated method stub
        
    }


    @Override
    public void startGame() {
        // TODO Auto-generated method stub
        
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
        // TODO Auto-generated method stub
        
    }


    @Override
    public void receivedBall(ArrayList<Ball> balls) {
        // TODO Auto-generated method stub
        
    }
}
