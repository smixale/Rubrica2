import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BarraPulsanti extends JPanel{
    
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

        Azioni();
    }

    private void Azioni (){

        nuovo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("pulsante nuovo");
            }
        });

        modifica.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("pulsante modifica");
            }
        });

        elimina.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("pulsante elimina");
            }
        });

    }
    
}
