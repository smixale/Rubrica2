package src.controller;

import java.io.FileNotFoundException;

import src.model.User;
import src.model.UserDatabase;
import src.view.FramePrincipale;
import src.view.PaginaLogin;

public class UserController {
    
    private FramePrincipale frame;
    private UserDatabase userDatabase;

    public UserController(FramePrincipale frame){
        
        this.frame = frame;
        userDatabase = new UserDatabase();

    }

    //verifica la presenza di un user nel database tramite username e passworld
    public boolean searchUser(User user){
        return userDatabase.searchUser(user);
    }

    public void CaricaFinestraPrincipale(){
        this.frame.remove(this.frame.getPaginaLogin());
        this.frame.remove(this.frame.getStrumentiLogin());
        this.frame.CaricaFinestraPrincipale();
    }

    public PaginaLogin getPaginaLogin(){
        return this.frame.getPaginaLogin();
    }

    public void salvaSuFile() throws FileNotFoundException{
        userDatabase.salvaSuFile();
    }

    public void caricaDaFile(){
        userDatabase.caricaDaFile();
    }

    public void addUser(User user){
        userDatabase.addUser(user);
    }
}
