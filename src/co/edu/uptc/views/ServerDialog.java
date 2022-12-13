package co.edu.uptc.views;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JDialog;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class ServerDialog extends JDialog implements Runnable{
    
    JTextArea textArea;

    public ServerDialog(){
        setSize(300,300);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setLocationRelativeTo(getParent());
        
        textArea = new JTextArea();
        textArea.setBounds(getBounds());
        add(textArea);
        Thread hilo = new Thread(this);
        hilo.start();
    }

    @Override
    public void run() {
        try {
            ServerSocket server = new ServerSocket(55555);
            Socket socket = server.accept();
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            String msg = dis.readUTF();
            textArea.append(msg);
            dis.close();
            socket.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
