package co.edu.uptc.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class ClientDialog extends JDialog {

    public ClientDialog(){
        setSize(300,300);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setLocationRelativeTo(getParent());

        JTextField textField = new JTextField();
        textField.setBounds(100,10, 100,30);
        add(textField);
        JButton btn = new JButton("Enviar");
        btn.setBounds(90, 50, 80,30);   
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Socket socket = new Socket("192.168.1.84",55555);
                    DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                    dos.writeUTF(textField.getText());
                    dos.close();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        }
            );
        add(btn);
    }    
}
