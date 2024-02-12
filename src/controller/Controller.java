package src.controller;

import src.model.Persona;
import src.view.Form;
import src.view.FramePrincipale;
import src.view.StrumentiFinestraPrincipale;
import src.view.StrumentiForm;
import src.view.TabellaRubrica;

import java.io.FileNotFoundException;
import java.util.List;

import src.model.Database;

public class Controller {

    FramePrincipale frame;
    Database database = new Database();
    private Persona selezionata;            //persona selezionata in caso di click su la tabella per eliminare o modificare

    public Controller(FramePrincipale frame){
        this.frame = frame;
        selezionata = null;
    }

    //strumenti di accesso al frame-------------------------------------
    public Form getForm() {
        return frame.getForm();
    }

    public StrumentiForm getStrumentiForm() {
        return frame.getStrumentiForm();
    }

    public StrumentiFinestraPrincipale getStrumenti() {
        return frame.getStrumenti();
    }

    public TabellaRubrica getTabellaRubrica() {
        return frame.getTabellaRubrica();
    }
    //--------------------------------------------------------------------

    public Persona getSelezionata() {
        return selezionata;
    }

    public void setSelezionata(Persona selezionata) {
        this.selezionata = selezionata;
    }
    
    public void addPersona(String nome, String cognome, String indirizzo, String telefono, int eta) throws FileNotFoundException{
        Persona persona = new Persona(nome, cognome, indirizzo, telefono, eta);
        database.addPersona(persona);
    }

    public List<Persona> getRubrica (){
        return database.getPersone();
    }

    public void salvaDatiSuFile() throws FileNotFoundException{
        database.salvaSuFile();
    }

    public void caricaDaFile (){
        database.caricaDaFile();
    }

    public Persona searchById(int id){
        return database.searchById(id);
    }

    //riceve l'id di ins persona selezionata nella tabella, la cerca nel database e la salva in una variabile d'appoggio
    public void selezionaPersonaById(int id){
        this.setSelezionata(this.searchById(id));
    }

    //rimuovo la persona dal database, resetto la persona selezionata e aggiorno la tabella
    public void eliminaPersona (){
        if (selezionata == null) {
            throw new RuntimeException("Il programma è stato interrotto a causa di un errore.");
        }
        database.eliminaPersona(this.getSelezionata().getId());
        this.setSelezionata(null);                                  //riporto la variabile di selezione al default
        this.getTabellaRubrica().aggiorna();
    }

    public void cancellaCampiForm(){
        this.getForm().resetCampi();
    }

    public void caricaPaginaPrincipale(){
        this.frame.CaricaFinestraPrincipale();
    }

    public void CaricaFinestraForm(){
        this.frame.CaricaFinestraForm();
    }

    public void modificaPersona(){
        if (selezionata == null) {
            throw new RuntimeException("Il programma è stato interrotto a causa di un errore.");
        }
        this.getForm().caricaDatiDaModificare(selezionata);                     //passo alla form i dati della persona da modificare
        this.CaricaFinestraForm();
        this.eliminaPersona();
        this.setSelezionata(null);                                  //riporto la variabile di selezione al default
    }
}
