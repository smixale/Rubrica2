package src.view;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import src.model.Persona;

public class Form extends JPanel{

    private JLabel etichettaNome;
    public JTextField campoNome;

    private JLabel etichettaCognome;
    public JTextField campoCognome;

    private JLabel etichettaIndirizzo;
    public JTextField campoIndirizzo;

    private JLabel etichettaTelefono;
    public JTextField campoTelefono;

    private JLabel etichettaEta;
    public JTextField campoEta;

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


        //nome
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.insets = new Insets(3, 0, 0, 2);
        add(etichettaNome,gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.insets = new Insets(3, 2, 0, 0);
        add(campoNome,gbc);

        //cognome
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(3, 0, 0, 2);
        add(etichettaCognome,gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.insets = new Insets(3, 2, 0, 0);
        add(campoCognome,gbc);

        //indirizzo
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(3, 0, 0, 2);
        add(etichettaIndirizzo,gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.insets = new Insets(3, 2, 0, 0);
        add(campoIndirizzo,gbc);

        //telefono
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.insets = new Insets(3, 2, 0, 2);
        add(etichettaTelefono,gbc);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.insets = new Insets(3, 2, 0, 0);
        add(campoTelefono,gbc);

        //età
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(etichettaEta,gbc);
        gbc.insets = new Insets(3, 0, 0, 2);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.insets = new Insets(3, 2, 0, 0);
        add(campoEta,gbc);
    }

    public void resetCampi(){
        campoNome.setText("");
        campoCognome.setText("");
        campoIndirizzo.setText("");
        campoTelefono.setText("");
        campoEta.setText("");
    }

    public void caricaDatiDaModificare(Persona p){
        this.campoNome.setText(p.getNome());
        this.campoCognome.setText(p.getCognome());
        this.campoIndirizzo.setText(p.getIndirizzo());
        this.campoTelefono.setText(p.getTelefono());
        this.campoEta.setText(Integer.toString(p.getEta()));
    }
}
