package src.view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import src.controller.UserController;
import src.model.User;

public class StrumentiLogin extends JPanel{
    
    private JButton login = new JButton("Login");
    private JButton registrati = new JButton("Registrati");
    public LoginListener loginListener;
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

                String username = userController.getPaginaLogin().getCampoUsername().getText();
                String passworld = userController.getPaginaLogin().getCampoPassworld().getText();

                User temp = new User(username, passworld);

                //verifico se le credenziali esistono nel sistema
                if (userController.searchUser(temp)) {
                    //se esistono carico la finestra principale del sistema
                    userController.CaricaFinestraPrincipale();
                    System.out.println("login eseguito");
                }else{
                    //se non esistono avverto l'utente
                    JOptionPane.showMessageDialog(null, "Username o passworld errati", "Attenzione", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        registrati.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
    }

    public void setLoginListener(LoginListener loginListener){
        this.loginListener = loginListener;
    }
}
