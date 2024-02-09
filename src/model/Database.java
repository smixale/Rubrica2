package src.model;

import java.util.ArrayList;

public class Database {

    ArrayList<Persona> rubrica;

    public Database(){
        rubrica = new ArrayList<>();
    }

    public void addPersona(Persona p){
        rubrica.add(p);
        System.out.println("persona aggiunta: " + p.getNome());
    }

    public ArrayList<Persona> getPersone (){
        return rubrica;
    }
}
