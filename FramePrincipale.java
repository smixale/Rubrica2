import javax.swing.JFrame;
import java.awt.BorderLayout;

public class FramePrincipale extends JFrame{

    AzioniPulsanti azioni = new AzioniPulsanti(this);
    StrumentiFinestraPrincipale strumenti = new StrumentiFinestraPrincipale(azioni);
    StrumentiForm strumentiForm = new StrumentiForm(azioni);

    public FramePrincipale (){

        super("frame principale");
        setLayout(new BorderLayout());
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
