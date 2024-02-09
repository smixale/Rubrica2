package src.controller;

import src.model.Persona;
import src.model.Database;

public class Controller {

    Database database = new Database();

    public Controller(){
        
    }
    
    public void addPersona(String nome, String cognome, String indirizzo, String telefono, int eta){
        Persona persona = new Persona(nome, cognome, indirizzo, telefono, eta);
        database.addPersona(persona);
    }
}
