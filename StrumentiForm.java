import javax.swing.JButton;
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
                Persona persona = new Persona(nome, cognome, indirizzo, telefono, 9999);

                EventoForm eventoForm = new EventoForm(this, persona);

                if (formListener != null) {
                    formListener.formEventListener(eventoForm);
                }
            }
        });

        annulla.addActionListener(azioni);
    }

    public void setFormListener(FormListener formListener){
        this.formListener = formListener;
    }
}
