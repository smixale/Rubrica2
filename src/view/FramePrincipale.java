package src.view;

import javax.swing.JFrame;

import src.controller.Controller;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;

public class FramePrincipale extends JFrame{

    Controller controller;

    AzioniPulsanti azioni = new AzioniPulsanti(this);

    Form form;;
    StrumentiForm strumentiForm;

    StrumentiFinestraPrincipale strumenti;
    private TabellaRubrica tabellaRubrica;



    public FramePrincipale (){
        super("frame principale");

        this.controller = new Controller(this);

        form = new Form();

        strumenti = new StrumentiFinestraPrincipale(azioni, controller);

        strumentiForm = new StrumentiForm(azioni, form, controller);

        tabellaRubrica = new TabellaRubrica(controller);
        tabellaRubrica.setData(controller.getRubrica());

        this.setListener();

        this.caricaDaFile();

        setLayout(new BorderLayout());
        add(tabellaRubrica,BorderLayout.CENTER);
        add(strumenti,BorderLayout.PAGE_END);
        AspettoFrame();
    }

    //raggruppo l'aggiunta dei diversi listener alle componenti
    private void setListener(){

        //listener per gerstire la creazione di una nuova persona tramite form
        strumentiForm.setFormListener(new FormListener(){
            @Override
            public void formEventListener(EventoForm ef){

                String nome  = ef.getNome();
                String cognome = ef.getCognome();
                String indirizzo = ef.getIndirizzo();
                String telefono = ef.getTelefono();
                int eta = ef.getEta();

                try {
                    controller.addPersona(nome, cognome, indirizzo, telefono, eta);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                tabellaRubrica.aggiorna();
                CaricaFinestraPrincipale();
            }
        });

        //listener per gestire la chiusura del frame
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e){
                try {
                    controller.salvaDatiSuFile();
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
            };
        });
    }

    //caricamento componenti pagina principale rubrica
    public void CaricaFinestraPrincipale(){        
        remove(strumentiForm);
        remove(form);

        add(tabellaRubrica,BorderLayout.CENTER);
        add(strumenti,BorderLayout.PAGE_END);
        revalidate();
        repaint();
    }

    //caricamento componenti form aggiunta persona in rubrica
    public void CaricaFinestraForm(){
        remove(strumenti);
        remove(tabellaRubrica);

        add(form,BorderLayout.CENTER);
        add(strumentiForm,BorderLayout.PAGE_END);
        revalidate();
        repaint();
    }

    //metodo che assegna le dimensioni e l'aspetto di default al frame
    private void AspettoFrame(){
        setSize(500,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void caricaDaFile(){
        controller.caricaDaFile();
        tabellaRubrica.aggiorna();
    }

    public Form getForm() {
        return form;
    }

    public StrumentiForm getStrumentiForm() {
        return strumentiForm;
    }

    public StrumentiFinestraPrincipale getStrumenti() {
        return strumenti;
    }

    public TabellaRubrica getTabellaRubrica() {
        return tabellaRubrica;
    }
}
