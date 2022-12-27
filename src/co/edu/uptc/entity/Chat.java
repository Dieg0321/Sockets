package co.edu.uptc.entity;

import java.io.Serializable;

import com.google.gson.Gson;

public class Chat implements Serializable{

    private String ip;
    private String message;

    public Chat(String ip, String message){
        this.ip = ip;
        this.message = message;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
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
