package co.edu.uptc.models;

//import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientManager {
    
    private Socket socket;

    public Socket getSocket() {
        return socket;
    }

    public void start(Client client){
        try  {
            socket = new Socket(client.getIp(), client.getPort());
            //DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // public void chatReceived(String className, String text ){
    //     new Chat();
    // }
}
