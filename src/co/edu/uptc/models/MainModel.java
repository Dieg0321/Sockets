package co.edu.uptc.models;

import java.util.ArrayList;

import co.edu.uptc.contract.MainContract;
import co.edu.uptc.contract.MainContract.Presenter;
import co.edu.uptc.entity.Client;

public class MainModel implements MainContract.Model{

   
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
        // TODO Auto-generated method stub
        
    }

    @Override
    public String getIp() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void startServer(int port) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void startClient(co.edu.uptc.entity.Client client) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public ArrayList<Client> getClients() {
        // TODO Auto-generated method stub
        return null;
    }

}