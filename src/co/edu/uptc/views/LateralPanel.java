package co.edu.uptc.views;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.uptc.entity.Chat;
import co.edu.uptc.views.myconstants.ButtonConstants;
import co.edu.uptc.views.myconstants.TitleConstants;

public class LateralPanel extends JPanel{

    private JTextField msgField;
    private JTextArea msg;
    private ClientDialog clientDialog;
    private Chat chat;

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
        clientsLabel.setFont(TitleConstants.LABELS_FONT);
        //clientsLabel.setBorder(new LineBorder(Color.red, 2));   
        add(clientsLabel);

        JLabel chatsLabel = new JLabel(TitleConstants.CHATS);
        chatsLabel.setBounds(23, 235, 100,30);
        chatsLabel.setFont(TitleConstants.LABELS_FONT);
        add(chatsLabel);
        
        JLabel sendMsgLabel = new JLabel(TitleConstants.SEND_MESSAGES);
        sendMsgLabel.setBounds(23, 475, 150,30);
        sendMsgLabel.setFont(TitleConstants.LABELS_FONT);
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
        msg = new JTextArea();
        //msg.append();
        msg.setEditable(false);

        JScrollPane chatsListScroll = new JScrollPane(msg);
        chatsListScroll.setBounds(25,265, 125,190);
        add(chatsListScroll);
    }

    public void createMessageTextField(){
        msgField = new JTextField();
        msgField.setBounds(25, 505, 125, 90);
        add(msgField);
    }

    public void setChat(Chat chat){
        this.chat = chat;
    }

    public void createSendButton(){
        JButton sendBtn = new JButton(ButtonConstants.SEND);
        sendBtn.setFont(TitleConstants.LABELS_FONT);
        sendBtn.setBounds(40, 615, 90, 30);
        sendBtn.addActionListener(createSendButtonListener());
        add(sendBtn);
    }

    public ActionListener createSendButtonListener(){
        return new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                MainBoard.getInstance().write(TitleConstants.CLIENT,msgField.getText());
                chat = MainBoard.getInstance().getChat();
                msg.append(chat.getIp()+"\n\t"+chat.getMessage());

            }

        };
    }

    public String getMsgField() {
        return msgField.getText();
    }

    public JTextArea getMsg() {
        return msg;
    }

    public Chat getChat() {
        return new Chat(MainBoard.getInstance().getClientDialog().getIp(), getMsgField());
    }

    public void setMsgField(JTextField msgField) {
        this.msgField = msgField;
    }

    public void setMsg(JTextArea msg) {
        this.msg = msg;
    }


}
