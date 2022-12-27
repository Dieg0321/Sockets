package co.edu.uptc.models;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.ArrayList;

import co.edu.uptc.contract.MainContract;
import co.edu.uptc.contract.MainContract.Model;
import co.edu.uptc.contract.MainContract.Presenter;
import co.edu.uptc.entity.Chat;
import co.edu.uptc.entity.Client;
import co.edu.uptc.presenter.MainPresenter;
import co.edu.uptc.views.MainBoard;

public class SocketManager implements Model {

    private ClientManager clientManager;
    private ArrayList<Client> clients;
    private ServerManager serverManager;

    public SocketManager() {
        clients = new ArrayList<>();
        serverManager = new ServerManager();
        clientManager = new ClientManager();
    }

    @Override
    public void startServer(int port) {
        serverManager.start(port);
    }

    @Override
    public void startClient(Client client) {
        clientManager.start(client);
    }
        
    public Chat createChat(){
        return MainPresenter.getInstance().getChat();
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
    public void setPresenter(Presenter presenter) {
        // TODO Auto-generated method stub
        
    }

    // @Override
    // public void write(String className, String text) {
    //     if(className.equals("Client")){
    //         clientManager.start(null);
    //         chatReceived();
    //         System.out.println("Entra");
    //     }
    // }

    @Override
    public ArrayList<Client> getClients() {
        return clients;
    }

    @Override
    public String getIp() {
        return serverManager.getSocketServer().getServer().getInetAddress().getHostAddress();
    }
    
    public ServerManager getServerManager() {
        return serverManager;
    }

    public void setServerManager(ServerManager serverManager) {
        this.serverManager = serverManager;
    }

    public ClientManager getClientManager() {
        return clientManager;
    }

    public void setClientManager(ClientManager clientManager) {
        this.clientManager = clientManager;
    }

    // public void chatReceived(){
    //     MainPresenter.getInstance().getChat(serverManager.jsonToChat());
    // }

    @Override
    public void write(String className, String text) {
        // TODO Auto-generated method stub
        
    }

    // public static SocketManager getInstance(){
    //     return instance;
    // }

}
