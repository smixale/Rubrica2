import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BarraPulsanti extends JPanel{
    
    private JButton nuovo = new JButton("nuovo");
    private JButton modifica = new JButton("modifica");
    private JButton elimina = new JButton("elimina");
    AzioniPulsanti azioni = new AzioniPulsanti();

    public BarraPulsanti (){
        setLayout(new FlowLayout(FlowLayout.CENTER,20,10));

        nuovo.setAlignmentX(LEFT_ALIGNMENT);
        modifica.setAlignmentX(CENTER_ALIGNMENT);
        elimina.setAlignmentX(RIGHT_ALIGNMENT);

        add(nuovo);
        add(modifica);
        add(elimina);

        nuovo.addActionListener(azioni);
        modifica.addActionListener(azioni);
        elimina.addActionListener(azioni);
    }
    
}
