import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class AzioniPulsanti implements ActionListener{

    FramePrincipale frame;

    public AzioniPulsanti (FramePrincipale frame){
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton premuto = (JButton) e.getSource();
        String nome = premuto.getName();

        if (nome.equals("nuovo")) {
            System.out.println("pulsante nuovo");
            frame.CaricaFinestraForm();
        }
        if (nome == "modifica") {
            System.out.println("pulsante modifica");
        }
        if (nome == "elimina") {
            System.out.println("pulsante elimina");
        }
        if (nome == "salva") {
            System.out.println("pulsante salva");
        }
        if (nome == "annulla") {
            System.out.println("pulsante annulla");
            frame.CaricaFinestraPrincipale();
        }
    }
    
}
