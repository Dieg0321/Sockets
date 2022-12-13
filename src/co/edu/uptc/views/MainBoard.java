package co.edu.uptc.views;

import java.io.ObjectInputFilter.Status;
import java.util.ArrayList;

import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import co.edu.uptc.contract.MainContract;
import co.edu.uptc.contract.MainContract.Presenter;
import co.edu.uptc.models.Ball;
import co.edu.uptc.models.Chat;
import co.edu.uptc.models.Client;

public class MainBoard extends JFrame implements MainContract.View {
    
    public static final int frameWidth = 600;
    public static final int frameHeight = 720;

    private static MainBoard instance;
    private LateralPanel lateralPanel;
    private MainMenu menuBar;

    public MainBoard(){
        initMainBoard();   
        createMenuBar();
        createLateralPanel();
        revalidate();
    }

    public void initMainBoard(){
        setSize(frameWidth, frameHeight);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
    }

    public void createMenuBar(){
        menuBar = new MainMenu();
        add(menuBar);
        setJMenuBar(menuBar);
    }

    public void createLateralPanel(){
        lateralPanel = new LateralPanel();
        add(lateralPanel, BorderLayout.EAST);
    }

    public static MainBoard getInstance(){
        if(instance == null){
            instance = new MainBoard();
        }
        return instance;
    }

    public int getS(){
        return getSize().width;
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
