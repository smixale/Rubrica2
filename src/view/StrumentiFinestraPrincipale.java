package src.view;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import src.controller.Controller;

public class StrumentiFinestraPrincipale extends JPanel{
    
    private JButton nuovo;
    private JButton modifica;
    private JButton elimina;
    

    public StrumentiFinestraPrincipale (AzioniPulsanti azioni, Controller controller){
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

        elimina.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (controller.getSelezionata() != null) {
                    //yes=0 no=1
                    if (JOptionPane.showConfirmDialog(null, "Vuoi emiminare " + controller.getSelezionata().getNome() +" " + controller.getSelezionata().getCognome() +"?", "Confermi?", JOptionPane.YES_NO_OPTION) == 0) {
                        //se si sceglie si
                        //rimuovo la persona selezionata dal database e aggiorno l atabella
                        controller.eliminaPersona();
                    }else{
                        //SE SI SCEGLIE NO
                        //non succede nulla
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Nessun contatto selezionato per l'eliminazione", "Errore", JOptionPane.ERROR_MESSAGE);
                }
            }
            
        });
    }
    
}
