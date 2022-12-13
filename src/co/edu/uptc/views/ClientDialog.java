package co.edu.uptc.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;

public class ClientDialog extends JDialog {

    private JTextField textField;

    public ClientDialog(){
        initComponent();
        createTextField();    
        createSendButton();
    }    

    private void createSendButton() {
        JButton btn = new JButton();
        btn.setBounds(90, 50, 80,30);   
        btn.addActionListener(createActionListener());
        add(btn);
    }

    public ActionListener createActionListener(){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Socket socket = new Socket("192.168.1.84", 55555);
                    DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                    dos.writeUTF(textField.getText());
                    dos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        };
    }

    public void initComponent(){
        setSize(300,300);
        setVisible(true);
    }

    public void createTextField(){
        textField = new JTextField();
        textField.setBounds(100,10, 100,30);
        add(textField);
    }

    
}
