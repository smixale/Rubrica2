package src.model;

public class User {
    
    private String username;
    private String passworld;

    public User(String username, String passworld){
        this.username = username;
        this.passworld = passworld;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassworld() {
        return passworld;
    }

    public void setPassworld(String passworld) {
        this.passworld = passworld;
    }

    @Override
    public boolean equals(Object obj) {
        //due utenti sono uguali se hanno la stessa passworld e username
        User other = (User) obj;
        return this.getUsername().equals(other.getUsername()) && this.getPassworld().equals(other.getPassworld());
    }
}
