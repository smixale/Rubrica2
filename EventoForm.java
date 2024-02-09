import java.util.EventObject;

public class EventoForm extends EventObject{

    private Persona persona;

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public EventoForm(Object source) {
        super(source);
    }

    public EventoForm(Object source, Persona persona) {
        super(source);
        this.persona = persona;
    }
    
}
