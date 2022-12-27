package co.edu.uptc.views;

import java.io.ObjectInputFilter.Status;
import java.util.ArrayList;

import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import co.edu.uptc.contract.MainContract;
import co.edu.uptc.contract.MainContract.Presenter;
import co.edu.uptc.entity.Chat;
import co.edu.uptc.entity.Client;
import co.edu.uptc.entity.Ball;
import co.edu.uptc.presenter.MainPresenter;

public class MainBoard extends JFrame implements MainContract.View {
    
    public static final int frameWidth = 600;
    public static final int frameHeight = 720;

    private LateralPanel lateralPanel;
    private MainMenu menuBar;
    private static String text;
    private static MainBoard instance = new MainBoard();
    private MainContract.Presenter presenter;
    private ServerDialog serverDialog;
    private ClientDialog clientDialog;
    private Chat chat;

    private MainBoard(){
        this.presenter = MainPresenter.getInstance();
        initMainBoard();   
        createMenuBar();
        createLateralPanel();
        revalidate();
    }

    public void initMainBoard(){
        setSize(frameWidth, frameHeight);
        setLocationRelativeTo(null);
        setVisible(true);
        // setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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
        return instance;
    }

    public int getS(){
        return getSize().width;
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }


    @Override
    public void startGame() {
      
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
        this.chat = chat;
    }

    public Chat createChat(){
        return lateralPanel.getChat();
    }

    public Chat getChat(){
        return chat;
    }  
    
    
    // public Client createClient(String ip, int port, Color color){
    //     return new Client(new color);
    // }

    @Override
    public void receivedBall(ArrayList<Ball> balls) {
        // TODO Auto-generated method stub
        
    }

    public void startServer(int port){
        presenter.startServer(port);
    }

    public void startClient(Client client){
        presenter.startClient(client);
    }

    void write(String className, String text){
        MainPresenter.getInstance().write(className, text);
    }

    public Presenter getPresenter(){
        return presenter;
    }

    public ClientDialog getClientDialog(){
        return clientDialog;
    }
    // public int getServerPort(){
    //     return Integer.parseInt(serverDialog.getPortTextField());
    // }


}
