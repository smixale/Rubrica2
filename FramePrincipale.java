import javax.swing.JFrame;
import java.awt.BorderLayout;

public class FramePrincipale extends JFrame{

    AzioniPulsanti azioni = new AzioniPulsanti(this);
    Form form = new Form();
    StrumentiFinestraPrincipale strumenti = new StrumentiFinestraPrincipale(azioni);
    StrumentiForm strumentiForm = new StrumentiForm(azioni,form);

    public FramePrincipale (){

        super("frame principale");
        setLayout(new BorderLayout());

        strumentiForm.setFormListener(new FormListener(){
            @Override
            public void formEventListener(EventoForm ef){
                System.out.println("AIUTATEMI PERCHE MI STO PERDENDO");
            }
        });

        add(strumenti,BorderLayout.PAGE_END);

        AspettoFrame();
    }

    protected void CaricaFinestraPrincipale(){
        //removeAll();
        
        remove(strumentiForm);
        add(strumenti,BorderLayout.PAGE_END);
        revalidate();
        repaint();
    }

    protected void CaricaFinestraForm(){
        //removeAll();
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
