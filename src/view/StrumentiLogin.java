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
                }else{
                    //se non esistono avverto l'utente
                    JOptionPane.showMessageDialog(null, "Username o passworld errati", "Attenzione", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        registrati.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userController.getPaginaLogin().getCampoUsername().getText();
                String passworld = userController.getPaginaLogin().getCampoPassworld().getText();

                if (nonVuoto(username) && nonVuoto(passworld)) {
                    //creo un nuovo utente solo se vengono inserite delle credenziali
                    User temp = new User(username, passworld);

                    if (userController.searchUser(temp)) {
                        JOptionPane.showMessageDialog(null, "Utente gia' registrato nel sistema", "Attenzione", JOptionPane.WARNING_MESSAGE);
                    }else{
                        userController.addUser(temp);
                        JOptionPane.showMessageDialog(null, "Registrazione completata", "Registrazione", JOptionPane.INFORMATION_MESSAGE);
                        userController.CaricaFinestraPrincipale();
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Riempi i campi per registrarti", "Attenzione", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }

    //verifico che la stringa inserita non sia vuota
    private boolean nonVuoto(String s){
        return !s.isEmpty() && s != null;
    }

    public void setLoginListener(LoginListener loginListener){
        this.loginListener = loginListener;
    }
}
