package src.view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import src.controller.UserController;

public class StrumentiLogin extends JPanel{
    
    private JButton login = new JButton("Login");
    private JButton registrati = new JButton("Registrati");
    private UserController userController;

    public StrumentiLogin(UserController userController){

        this.userController = userController;

        setLayout(new FlowLayout(FlowLayout.CENTER,20,10));

        this.setActionListener();

        add(login);
        add(registrati);
    }

    private void setActionListener(){

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (verificaDati()) {
                    if (userController.isUser(null)) {
                        //TODO
                    }else{
                        JOptionPane.showMessageDialog(null, "Username o passworld errati", "Attenzione", JOptionPane.WARNING_MESSAGE);
                    }
                }else{

                }
            }
        });

        registrati.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
    }

    private boolean verificaDati(){
        //TODO evento login
        return true;
    }
}
