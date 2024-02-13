package src.controller;

import src.model.User;
import src.model.UserDatabase;

public class UserController {
    
    private UserDatabase userDatabase;

    public UserController(){
        
        userDatabase = new UserDatabase();

    }

    public boolean isUser(User user){
        return userDatabase.isUser(user);
    }
}
