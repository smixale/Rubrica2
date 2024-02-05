import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BarraPulsanti extends JPanel implements ActionListener{
    
    private JButton nuovo = new JButton("nuovo");
    private JButton modifica = new JButton("modifica");
    private JButton elimina = new JButton("elimina");

    public BarraPulsanti (){
        setLayout(new FlowLayout(FlowLayout.CENTER,20,10));

        nuovo.setAlignmentX(LEFT_ALIGNMENT);
        modifica.setAlignmentX(CENTER_ALIGNMENT);
        elimina.setAlignmentX(RIGHT_ALIGNMENT);

        add(nuovo);
        add(modifica);
        add(elimina);

        nuovo.addActionListener(this);
        modifica.addActionListener(this);
        elimina.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton premuto = (JButton) e.getSource();

        if (premuto == nuovo) {
            System.out.println("pulsante nuovo");
        }
        if (premuto == modifica) {
            System.out.println("pulsante modifica");
        }
        if (premuto == elimina) {
            System.out.println("pulsante elimina");
        }
    }
    
}
