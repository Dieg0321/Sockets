package co.edu.uptc.views;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import co.edu.uptc.views.myconstants.ButtonConstants;

public class MainMenu extends JMenuBar{

    private JMenu configMenu;
    private JMenu helpMenu;
    private ServerDialog serverDialog;

    public MainMenu(){
        //init();
        configMenu = createMenu(ButtonConstants.CONFIGURATION);
        helpMenu = createMenu(ButtonConstants.HELP);
        createButton(ButtonConstants.CLIENT);
        createButton(ButtonConstants.SERVER);
        createButton(ButtonConstants.EXIT);
    }

    public JMenu createMenu(String label){
        JMenu menu = new JMenu(label);
        add(menu);
        return menu;
    }

    public void createButton(String btnOption){
        JMenuItem button = new JMenuItem(btnOption);
		button.addActionListener(createListener());
        button.setActionCommand(btnOption);
		configMenu.add(button);
    }

    public ActionListener createListener(){
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                switch(e.getActionCommand()){
                    case ButtonConstants.CLIENT:
                        new ClientDialog();
                        break;
                    case ButtonConstants.SERVER:
                        new ServerDialog();
                        break;
                    case ButtonConstants.EXIT:
                        System.exit(0);;
                        return;
                    default:
                        System.out.println("NELLL!!!");
                        break;
                }
            }
            
        };
    }

}
