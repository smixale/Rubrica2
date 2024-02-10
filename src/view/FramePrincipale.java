package src.view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import src.model.Persona;
import src.controller.Controller;

import java.awt.BorderLayout;
import java.util.ArrayList;

public class FramePrincipale extends JFrame{

    AzioniPulsanti azioni = new AzioniPulsanti(this);
    Controller controller;


    Form form = new Form();
    StrumentiForm strumentiForm = new StrumentiForm(azioni,form);

    StrumentiFinestraPrincipale strumenti = new StrumentiFinestraPrincipale(azioni);
    private TabellaRubrica tabellaRubrica = new TabellaRubrica();



    public FramePrincipale (){
        super("frame principale");

        this.controller = new Controller();
        tabellaRubrica.setData(controller.getRubrica());

        strumentiForm.setFormListener(new FormListener(){
            @Override
            public void formEventListener(EventoForm ef){
                System.out.println("AIUTATEMI PERCHE MI STO PERDENDO " + ef.getNome());

                String nome  = ef.getNome();
                String cognome = ef.getCognome();
                String indirizzo = ef.getIndirizzo();
                String telefono = ef.getTelefono();
                int eta = ef.getEta();

                if (ef.isValido()) {                    
                    controller.addPersona(nome, cognome, indirizzo, telefono, eta);
                    tabellaRubrica.aggiorna();
                    CaricaFinestraPrincipale();
                }else{
                    JOptionPane.showMessageDialog(null, "Attenzione dati mancanti o non validi", "Attenzione", JOptionPane.WARNING_MESSAGE);
                }
            }
        });



        setLayout(new BorderLayout());
        add(tabellaRubrica,BorderLayout.CENTER);
        add(strumenti,BorderLayout.PAGE_END);
        AspettoFrame();
    }

    //caricamento componenti pagina principale rubrica
    protected void CaricaFinestraPrincipale(){        
        remove(strumentiForm);
        remove(form);

        add(tabellaRubrica,BorderLayout.CENTER);
        add(strumenti,BorderLayout.PAGE_END);
        revalidate();
        repaint();
    }

    //caricamento componenti form aggiunta persona in rubrica
    protected void CaricaFinestraForm(){
        remove(strumenti);
        remove(tabellaRubrica);

        this.form.resetCampi();
        add(form,BorderLayout.CENTER);
        add(strumentiForm,BorderLayout.PAGE_END);
        revalidate();
        repaint();
    }


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
}
