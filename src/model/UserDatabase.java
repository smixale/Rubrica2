package src.model;

import java.util.ArrayList;

public class UserDatabase {
    
    ArrayList<User> utenti;

    public UserDatabase() {
        utenti = new ArrayList<>();
    }

    public boolean isUser(User user){
        for (User u : utenti) {
            if (u.equals(user)) {
                return true;
            }
        }
        return false;
    }
}
