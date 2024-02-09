import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.util.ArrayList;

public class FramePrincipale extends JFrame{

    AzioniPulsanti azioni = new AzioniPulsanti(this);
    ArrayList<Persona> rubrica;

    Form form = new Form();
    StrumentiForm strumentiForm = new StrumentiForm(azioni,form);

    StrumentiFinestraPrincipale strumenti = new StrumentiFinestraPrincipale(azioni);

    public FramePrincipale (ArrayList<Persona> rubrica){

        super("frame principale");
        this.rubrica = rubrica;
        setLayout(new BorderLayout());

        strumentiForm.setFormListener(new FormListener(){
            @Override
            public void formEventListener(EventoForm ef){
                rubrica.add(ef.getPersona());
                System.out.println("AIUTATEMI PERCHE MI STO PERDENDO " + ef.getPersona().getNome());
                CaricaFinestraPrincipale();
            }
        });

        add(strumenti,BorderLayout.PAGE_END);

        AspettoFrame();
    }

    //caricamento componenti pagina principale rubrica
    protected void CaricaFinestraPrincipale(){        
        remove(strumentiForm);
        add(strumenti,BorderLayout.PAGE_END);
        revalidate();
        repaint();
    }

    //caricamento componenti form aggiunta persona in rubrica
    protected void CaricaFinestraForm(){
        remove(strumenti);
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
