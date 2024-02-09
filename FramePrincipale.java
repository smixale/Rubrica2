import javax.swing.JFrame;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.util.ArrayList;

public class FramePrincipale extends JFrame{

    AzioniPulsanti azioni = new AzioniPulsanti(this);
    ArrayList<Persona> rubrica;

    Form form = new Form();
    StrumentiForm strumentiForm = new StrumentiForm(azioni,form);

    StrumentiFinestraPrincipale strumenti = new StrumentiFinestraPrincipale(azioni);
    private JTextArea pannelloRubrica = new JTextArea();

    public FramePrincipale (ArrayList<Persona> rubrica){

        super("frame principale");
        this.rubrica = rubrica;
        setLayout(new BorderLayout());

        strumentiForm.setFormListener(new FormListener(){
            @Override
            public void formEventListener(EventoForm ef){
                rubrica.add(ef.getPersona());
                System.out.println("AIUTATEMI PERCHE MI STO PERDENDO " + ef.getPersona().getNome());
                pannelloRubrica.append(ef.getPersona().getNome() + "\n");
                CaricaFinestraPrincipale();
            }
        });

        add(pannelloRubrica,BorderLayout.CENTER);
        add(strumenti,BorderLayout.PAGE_END);

        AspettoFrame();
    }

    //caricamento componenti pagina principale rubrica
    protected void CaricaFinestraPrincipale(){        
        remove(strumentiForm);
        remove(form);

        add(pannelloRubrica,BorderLayout.CENTER);
        add(strumenti,BorderLayout.PAGE_END);
        revalidate();
        repaint();
    }

    //caricamento componenti form aggiunta persona in rubrica
    protected void CaricaFinestraForm(){
        remove(strumenti);
        remove(pannelloRubrica);

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
}
