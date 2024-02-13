package src.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class UserDatabase {
    
    ArrayList<User> utenti;

    public UserDatabase() {
        utenti = new ArrayList<>();
    }

    public boolean searchUser (User temp){
        return utenti.contains(temp);
    }

    public void addUser(User user){
        utenti.add(user);
    }

    //salvo su un file la lista di utenti registrati al sistema
    public void salvaSuFile () throws FileNotFoundException{
        PrintStream ps = new PrintStream("src\\data\\Utenti.txt");
        for (User utente : utenti) {
            ps.println(utente.getUsername() + ";" + utente.getPassworld());
        }
    }

    public void caricaDaFile(){

        File file = new File("src\\data\\Utenti.txt");
        Scanner scanner;

        try {
            scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String riga = scanner.nextLine();
                String[] parti = riga.split(";");
    
                if (parti.length == 2) {
                    String username = parti[0];
                    String passworld = parti[1];
    
                    User u = new User(username, passworld);

                    this.addUser(u);
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
