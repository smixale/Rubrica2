package src.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

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
        PrintStream ps = new PrintStream("src\\data\\Rubrica.txt");
        for (Persona persona : rubrica) {
            ps.println(persona.getNome() + ";" + persona.getCognome() + ";" + persona.getIndirizzo() + ";" + persona.getTelefono() + ";" + persona.getEta());
        }
    }

    public void caricaDaFile(){

        File file = new File("src\\data\\Rubrica.txt");
        Scanner scanner;

        try {
            scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String riga = scanner.nextLine();
                String[] parti = riga.split(";");
    
                if (parti.length == 5) {
                    String nome = parti[0];
                    String cognome = parti[1];
                    String indirizzo = parti[2];
                    String telefono = parti[3];
                    int eta = Integer.parseInt(parti[4]);
    
                    Persona p = new Persona(nome, cognome, indirizzo, telefono, eta);

                    System.out.println("recupero " + nome + " dal file");

                    this.addPersona(p);
                }else{
                    JOptionPane.showMessageDialog(null, "Errore durante il caricamento dei dati da la memoria", "Errore", JOptionPane.ERROR_MESSAGE);
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Errore file non trovato", "Errore", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }


       

    }
}
