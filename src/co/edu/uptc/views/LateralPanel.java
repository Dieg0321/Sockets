package co.edu.uptc.views;

import co.edu.uptc.views.MainBoard;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Point;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import co.edu.uptc.views.myconstants.ButtonConstants;
import co.edu.uptc.views.myconstants.TitleConstants;

public class LateralPanel extends JPanel{

    public LateralPanel(){
        initLateralPanel();
        createTitles();
        createClientsJList();
        createChatsTextArea(); 
        createMessageTextField();
        createSendButton();
    }
    
    public void initLateralPanel(){
        setLayout(null);
        setBorder(new LineBorder(Color.gray, 1));
        setPreferredSize(new Dimension(170, MainBoard.frameHeight));
        setBackground(Color.lightGray);
    }

    public void createTitles(){
        JLabel clientsLabel = new JLabel(TitleConstants.CLIENTS);
        clientsLabel.setBounds(23, 0, 100,30);
        clientsLabel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 17));
        //clientsLabel.setBorder(new LineBorder(Color.red, 2));   
        add(clientsLabel);

        JLabel chatsLabel = new JLabel(TitleConstants.CHATS);
        chatsLabel.setBounds(23, 235, 100,30);
        chatsLabel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 17));
        add(chatsLabel);
        
        JLabel sendMsgLabel = new JLabel(TitleConstants.SEND_MESSAGES);
        sendMsgLabel.setBounds(23, 475, 150,30);
        sendMsgLabel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 17));
        add(sendMsgLabel);


    }

    public void createClientsJList(){
        String[] clients = {"192.1.1","192.1.1", "192.1.1"};
        JList<String> clientsList = new JList<String>(clients);

        JScrollPane clientsListScroll = new JScrollPane(clientsList);
        clientsListScroll.setBounds(23, 25,125,190);
        add(clientsListScroll);
    }

    public void createChatsTextArea(){
        JTextArea msg = new JTextArea();
        //msg.setEditable(false);

        JScrollPane chatsListScroll = new JScrollPane(msg);
        chatsListScroll.setBounds(25,265, 125,190);
        add(chatsListScroll);
    }

    public void createMessageTextField(){
        JTextField msgField = new JTextField();
        msgField.setBounds(25, 505, 125, 90);
        add(msgField);
    }

    public void createSendButton(){
        JButton sendBtn = new JButton(ButtonConstants.SEND);
        sendBtn.setFont(new Font(Font.MONOSPACED, Font.BOLD, 17));
        sendBtn.setBounds(40, 615, 90, 30);
        add(sendBtn);
    }

}
