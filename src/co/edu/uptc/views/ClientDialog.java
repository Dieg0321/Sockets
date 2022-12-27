package co.edu.uptc.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import co.edu.uptc.entity.Client;
import co.edu.uptc.presenter.MainPresenter;
import co.edu.uptc.views.myconstants.ButtonConstants;
import co.edu.uptc.views.myconstants.TitleConstants;

public class ClientDialog extends JDialog {

    private JTextField ipTextField;
    private JTextField portTextField;
    private Color color;

    public ClientDialog(){
        initComponent();
        createLabels();
        createTextField();    
        createChooseColorButton();
        createSendButton();
        createCancelButton();
    }    

    public void initComponent(){
        setSize(300,250);
        setLocationRelativeTo(getParent());
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public void createLabels(){
        JLabel ipLabel = new JLabel(TitleConstants.IP);
        ipLabel.setBounds(30,20,40,20);
        ipLabel.setFont(TitleConstants.LABELS_FONT);
        add(ipLabel);

        JLabel portLabel = new JLabel(TitleConstants.PORT);
        portLabel.setBounds(30,70,40,20);
        portLabel.setFont(TitleConstants.LABELS_FONT);
        add(portLabel);

        JLabel colorLabel = new JLabel(TitleConstants.COLOR);
        colorLabel.setBounds(30,115,50,20);
        colorLabel.setFont(TitleConstants.LABELS_FONT);
        add(colorLabel);
    }
    
    public void createTextField(){
        ipTextField = new JTextField();
        ipTextField.setBounds(90,20, 100,25);
        add(ipTextField);

        portTextField = new JTextField();
        portTextField.setBounds(90,65, 70,25);
        add(portTextField);
    }

    public void createChooseColorButton(){
        JButton colorButton = new JButton(ButtonConstants.SELECT);
        colorButton.setBounds(90, 115, 80,20);
        colorButton.addActionListener(createChooseColorListener());
        add(colorButton);
    }

    public ActionListener createChooseColorListener(){
        return new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                color = JColorChooser.showDialog(rootPane, "Color de usuario", Color.red);
            }

        };
    }

    public void createSendButton() {
        JButton btn = new JButton(ButtonConstants.RUN);
        btn.setBounds(30, 170, 80,30);   
        btn.addActionListener(createSendListener());
        add(btn);
    }

    public void createCancelButton() {
        JButton btn = new JButton(ButtonConstants.CANCEL);
        btn.setBounds(180, 170, 80,30);   
        btn.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }

        });
        add(btn);
    }

    public ActionListener createSendListener(){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainBoard.getInstance().startClient(MainPresenter.getInstance().createClient(ipTextField.getText(), getPort(), color));
              
            }
        };
    }

    public String getIp(){
        return ipTextField.getText();
    }

    public int getPort(){
        return Integer.parseInt(portTextField.getText());
    }

    public Color getColor(){
        return color;
    }
}
