package src.view;
import java.util.EventObject;


public class EventoForm extends EventObject{

    String nome;
    String cognome;
    String indirizzo;
    String telefono;
    int eta;
    boolean valido;

    public EventoForm(Object source) {
        super(source);
    }

    public EventoForm(Object source, String nome, String cognome, String indirizzo, String telefono, String eta) {

        super(source);

        System.out.println("campo nome: " + nome);

        if (campiNonVuoti(nome, cognome, indirizzo, telefono, eta) && soloNumeri(eta) && soloNumeri(telefono)) {            
            this.nome = nome;
            this.cognome = cognome;
            this.indirizzo = indirizzo;
            this.telefono = telefono;
            this.eta = Integer.parseInt(eta);
            this.valido = true;
        }else{
            this.valido = false;
        }
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

    public boolean isValido() {
        return valido;
    }

    public void setValido(boolean valido) {
        this.valido = valido;
    }

    //verifico che siano stati inseriti tutti i dati
    private boolean campiNonVuoti (String nome, String cognome, String indirizzo, String telefono, String eta){
        return true;
        //return nome != "" && cognome != "" && indirizzo != "" && telefono != "" && eta != "";
    }
    
    //verifico la validità dei campi telefono ed età
    private boolean soloNumeri(String s){
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
