package co.edu.uptc.models;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.ArrayList;


import co.edu.uptc.contract.MainContract.Model;
import co.edu.uptc.contract.MainContract.Presenter;

public class SocketManager implements Model {

    private ClientManager clientManager;

    private ArrayList<Client> clients;
    private ServerManager serverManager;

    public SocketManager() {
        serverManager = new ServerManager();
        clientManager = new ClientManager();
    }

    @Override
    public void startServer(int port) {
        serverManager.createSocket(port);
        serverManager.start();
    }

    @Override
    public void startClient(Client client) {
        clientManager.start(client);
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

    @Override
    public void write(String className, String text) {
        
        
    }

    @Override
    public ArrayList<Client> getClients() {
        return clients;
    }

    @Override
    public String getIp() {
        try {
            return Inet4Address.getLocalHost().toString();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        };
        return null;
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


}
