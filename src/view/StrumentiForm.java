package src.view;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StrumentiForm extends JPanel{

    private JButton salva = new JButton("salva");
    private JButton annulla = new JButton("annulla");
    private FormListener formListener;

    public StrumentiForm(AzioniPulsanti azioni, Form form){
        setLayout(new FlowLayout(FlowLayout.CENTER,20,10));

        add(salva);
        add(annulla);

        salva.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = form.campoNome.getText();
                String cognome = form.campoCognome.getText();
                String indirizzo = form.campoIndirizzo.getText();
                String telefono = form.campoTelefono.getText();
                String eta = form.campoEta.getText();

                //verifico che i dati siano validi e in caso creo un nuovo evento form
                if (campiNonVuoti(nome, cognome, indirizzo, telefono, eta) && soloNumeri(eta) && soloNumeri(telefono)) {                
                    EventoForm eventoForm = new EventoForm(this, nome, cognome, indirizzo, telefono, Integer.parseInt(eta));
                    if (formListener != null) {
                        formListener.formEventListener(eventoForm);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Attenzione dati mancanti o non validi", "Attenzione", JOptionPane.WARNING_MESSAGE);
                }

            }
        });

        annulla.addActionListener(azioni);
    }

    public void setFormListener(FormListener formListener){
        this.formListener = formListener;
    }

    //verifico che siano stati inseriti tutti i dati
    private boolean campiNonVuoti (String nome, String cognome, String indirizzo, String telefono, String eta){
        return !nome.isEmpty() && !cognome.isEmpty() && !indirizzo.isEmpty() && !telefono.isEmpty() && !eta.isEmpty();
    }

    //verifico la validità dei campi telefono ed età
    private boolean soloNumeri(String s){
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
