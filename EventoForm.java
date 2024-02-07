import java.util.EventObject;

public class EventoForm extends EventObject{

    Persona persona;

    public EventoForm(Object source) {
        super(source);
    }

    public EventoForm(Object source, Persona persona) {
        super(source);
        this.persona = persona;
    }
    
}
