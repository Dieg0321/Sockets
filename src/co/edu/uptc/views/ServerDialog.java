package co.edu.uptc.views;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import co.edu.uptc.views.myconstants.ButtonConstants;
import co.edu.uptc.views.myconstants.TitleConstants;

public class ServerDialog extends JDialog {

    private String ip;
    private JTextField portTextField;

    public ServerDialog(){
        ip = "192.168.1.68";
        
        initComponent();
        createLabels();
        createTextField();
        createSendButton();
        createCancelButton();
    }
    
    public void initComponent(){
        setSize(300,200);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(getParent());
    }

    public void createLabels(){
        JLabel ipLabel = new JLabel(TitleConstants.IP);
        ipLabel.setBounds(30,20,40,20);
        ipLabel.setFont(TitleConstants.LABELS_FONT);
        add(ipLabel);

        JLabel showIpLabel = new JLabel(ip);
        showIpLabel.setBounds(90,20,100,20);
        showIpLabel.setFont(new Font(Font.SERIF,Font.PLAIN,16));
        add(showIpLabel);

        JLabel portLabel = new JLabel(TitleConstants.PORT);
        portLabel.setBounds(30,70,40,20);
        portLabel.setFont(TitleConstants.LABELS_FONT);
        add(portLabel);
    }

    public void createTextField(){
        portTextField = new JTextField();
        portTextField.setBounds(90,65, 70,25);
        add(portTextField);
    }

    public void createSendButton() {
        JButton btn = new JButton(ButtonConstants.RUN);
        btn.setBounds(30, 120, 80,30);   
        btn.addActionListener(createSendListener());
        add(btn);
    }

    public ActionListener createSendListener(){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainBoard.getInstance().startServer(getPort());
                dispose();
            }            
        };
    }

    public void createCancelButton() {
        JButton btn = new JButton(ButtonConstants.CANCEL);
        btn.setBounds(180, 120, 80,30);   
        btn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        add(btn);
    }

    public int getPort() {
        return Integer.parseInt(portTextField.getText());
    }

}
