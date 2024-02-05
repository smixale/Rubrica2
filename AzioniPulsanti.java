import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class AzioniPulsanti implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton premuto = (JButton) e.getSource();
        String nome = premuto.getName();

        if (nome == "nuovo") {
            System.out.println("pulsante nuovo");
        }
        if (nome == "modifica") {
            System.out.println("pulsante modifica");
        }
        if (nome == "elimina") {
            System.out.println("pulsante elimina");
        }
    }
    
}
