package co.edu.uptc.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputFilter.Status;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import co.edu.uptc.contract.MainContract;
import co.edu.uptc.contract.MainContract.Presenter;
import co.edu.uptc.models.Ball;
import co.edu.uptc.models.Chat;
import co.edu.uptc.models.Client;

public class MainBoard extends JFrame implements MainContract.View {
    
    private static MainBoard instance;

    /**
     * 
     */
    public MainBoard(){
        setSize(500,500);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JButton clientBtn = new JButton("Cliente");
        clientBtn.setBounds(150,100,80,60);
        clientBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new ClientDialog();
            }
        }
        );
        add(clientBtn);

        JButton serverBtn = new JButton("Server");
        serverBtn.setBounds(240,100,80,60);
        serverBtn.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                new ServerDialog();
                
            }

        });
        add(serverBtn);
    }

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
