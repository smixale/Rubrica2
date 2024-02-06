import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class StrumentiFinestraPrincipale extends JPanel{
    
    private JButton nuovo;
    private JButton modifica;
    private JButton elimina;
    

    public StrumentiFinestraPrincipale (AzioniPulsanti azioni){
        this.nuovo = new JButton("nuovo");
        this.modifica = new JButton("modifica");
        this.elimina = new JButton("elimina");
        

        setLayout(new FlowLayout(FlowLayout.CENTER,20,10));

        
        add(nuovo);
        add(modifica);
        add(elimina);
        
        this.nuovo.setAlignmentX(LEFT_ALIGNMENT);
        this.modifica.setAlignmentX(CENTER_ALIGNMENT);
        this.elimina.setAlignmentX(RIGHT_ALIGNMENT);
        
        this.nuovo.addActionListener(azioni);
        this.modifica.addActionListener(azioni);
        this.elimina.addActionListener(azioni);
    }
    
}
