package src.view;
import java.util.EventObject;

import src.model.Persona;

public class EventoForm extends EventObject{

    String nome;
    String cognome;
    String indirizzo;
    String telefono;
    int eta;

    public EventoForm(Object source) {
        super(source);
    }

    public EventoForm(Object source, String nome, String cognome, String indirizzo, String telefono, int eta) {
        super(source);
        this.nome = nome;
        this.cognome = cognome;
        this.indirizzo = indirizzo;
        this.telefono = telefono;
        this.eta = eta;
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }
    
}
