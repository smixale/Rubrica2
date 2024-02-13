package src.view;

public class EventoLogin {
    
    String username;
    String passworld;
    
    public EventoLogin(String username, String passworld) {
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

    
}
