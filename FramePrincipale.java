import javax.swing.JFrame;
import java.awt.BorderLayout;

public class FramePrincipale extends JFrame{

    AzioniPulsanti azioni = new AzioniPulsanti(this);
    StrumentiFinestraPrincipale strumenti = new StrumentiFinestraPrincipale(azioni);
    StrumentiForm strumentiForm = new StrumentiForm(azioni);

    public FramePrincipale (){

        super("frame principale");
        setLayout(new BorderLayout());
        CaricaFinestraPrincipale();

        AspettoFrame();
    }

    protected void CaricaFinestraPrincipale(){
        //removeAll();
        
        add(strumenti,BorderLayout.PAGE_END);
    }

    protected void CaricaFinestraForm(){
        //removeAll();
        
        add(strumentiForm,BorderLayout.PAGE_END);
    }

    private void AspettoFrame(){
        setSize(500,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
