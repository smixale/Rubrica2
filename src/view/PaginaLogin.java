package src.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import src.controller.UserController;

public class PaginaLogin extends JPanel{
    
    private JLabel etichettaUsername;
    private JTextField campoUsername;

    private JLabel etichettaPassworld;
    private JTextField campoPassworld; 

    public PaginaLogin(UserController userController){

        setLayout(new GridBagLayout());

        etichettaUsername = new JLabel("Username: ");
        etichettaPassworld = new JLabel("Passworld: ");

        campoUsername = new JTextField(20);
        campoPassworld = new JTextField(20);

        GridBagConstraints gbc = new GridBagConstraints();

        //username
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.insets = new Insets(3, 0, 0, 2);
        add(etichettaUsername,gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.insets = new Insets(3, 2, 0, 0);
        add(campoUsername,gbc);

        //passworld
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(3, 0, 0, 2);
        add(etichettaPassworld,gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.insets = new Insets(3, 2, 0, 0);
        add(campoPassworld,gbc);
    }

    public void resetCampi(){
        campoUsername.setText("");
        campoPassworld.setText("");
    }
}
