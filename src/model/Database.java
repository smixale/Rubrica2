package src.model;

import java.io.FileNotFoundException;
import java.io.PrintStream;
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

    public void salvaSuFile() throws FileNotFoundException{
        PrintStream ps = new PrintStream("C:\\github\\Rubrica\\Rubrica2\\src\\data\\Rubrica.txt");
        for (Persona persona : rubrica) {
            ps.println(persona.getNome() + ";" + persona.getCognome() + ";" + persona.getIndirizzo() + ";" + persona.getTelefono() + ";" + persona.getEta());
        }
    }
}
