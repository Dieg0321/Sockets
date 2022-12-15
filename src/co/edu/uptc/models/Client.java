package co.edu.uptc.models;

import java.awt.Color;
import java.io.Serializable;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
public class Client implements Serializable{

    private String ip;
    private int port;
    private Color color;


    
    public Client(String ip, int port, Color color) {
        this.color = color;
        this.ip = ip;
        this.port = port;
    }


    public Client(){
        
    }


    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String toJson(){
        GsonBuilder gsonBuilder = new GsonBuilder().registerTypeAdapter(Color.class, new ColorSerializer());
        Gson gson = gsonBuilder.create();
        return gson.toJson(this);
    }

}
