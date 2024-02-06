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
        String testo = premuto.getText();

        if (testo == "nuovo") {
            System.out.println("pulsante nuovo");
            frame.CaricaFinestraForm();
        }
        if (testo == "modifica") {
            System.out.println("pulsante modifica");
        }
        if (testo == "elimina") {
            System.out.println("pulsante elimina");
        }
        if (testo == "salva") {
            System.out.println("pulsante salva");
        }
        if (testo == "annulla") {
            System.out.println("pulsante annulla");
            frame.CaricaFinestraPrincipale();
        }
    }
    
    public void prova(){
        System.out.println("prova azioni fghbwt");
    }
}
