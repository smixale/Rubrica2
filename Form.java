import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Form extends JPanel{
    private JLabel etichettaNome;
    private JTextField campoNome;

    private JLabel etichettaCognome;
    private JTextField campoCognome;

    private JLabel etichettaIndirizzo;
    private JTextField campoIndirizzo;

    private JLabel etichettaTelefono;
    private JTextField campoTelefono;

    private JLabel etichettaEta;
    private JTextField campoEta;

    public Form(){

        setLayout(new GridBagLayout());

        etichettaNome = new JLabel("Nome: ");
        etichettaCognome = new JLabel("Cognome: ");
        etichettaIndirizzo = new JLabel("Indirizzo: ");
        etichettaTelefono = new JLabel("Telefono: ");
        etichettaEta = new JLabel("Eta': ");

        campoNome = new JTextField(20);
        campoCognome = new JTextField(20);
        campoIndirizzo = new JTextField(20);
        campoTelefono = new JTextField(20);
        campoEta = new JTextField(20);

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
    }
}
