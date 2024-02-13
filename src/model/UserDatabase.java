package src.model;

import java.util.ArrayList;

public class UserDatabase {
    
    ArrayList<User> utenti;

    public UserDatabase() {
        utenti = new ArrayList<>();
        utenti.add(new User("admin", "admin"));
    }

    public boolean searchUser (User temp){
        return utenti.contains(temp);
    }
}
