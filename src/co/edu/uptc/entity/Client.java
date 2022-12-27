package co.edu.uptc.entity;

import java.awt.Color;
import java.io.Serializable;
import java.net.Socket;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.edu.uptc.models.ColorSerializer;
public class Client implements Serializable{

    private Socket socket;
    private Color color;

    public Client(Socket socket, Color color) {
        this.color = color;
        this.socket = socket;
    }


    public Client(){
        
    }


    public Socket getSocket(){
        return socket;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String toJson(){
        GsonBuilder gsonBuilder = new GsonBuilder().registerTypeAdapter(Color.class, new ColorSerializer());
        Gson gson = gsonBuilder.create();
        return gson.toJson(this);
    }

}
