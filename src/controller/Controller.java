package src.controller;

import src.model.Persona;

import java.io.FileNotFoundException;
import java.util.List;

import src.model.Database;

public class Controller {

    Database database = new Database();

    public Controller(){
        
    }
    
    public void addPersona(String nome, String cognome, String indirizzo, String telefono, int eta){
        Persona persona = new Persona(nome, cognome, indirizzo, telefono, eta);
        database.addPersona(persona);
    }

    public List<Persona> getRubrica (){
        return database.getPersone();
    }

    public void salvaDatiSuFile() throws FileNotFoundException{
        database.salvaSuFile();
    }
}
