package co.edu.uptc.models;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {

    public Client(){
        try {
            Socket socket = new Socket("192.168.1.84",55555);
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            //dos.writeUTF();
            dos.close();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    
    }

}
