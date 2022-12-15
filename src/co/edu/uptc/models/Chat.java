package co.edu.uptc.models;

import java.io.Serializable;

import com.google.gson.Gson;

public class Chat implements Serializable{

    private Client client;
    private String message;

    public Chat(){
        
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    
    public String chatToJson(){
        Gson gson = new Gson();
        return gson.toJson(this);
    }

}
