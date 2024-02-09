package src.view;
import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import src.model.Persona;

public class TabellaRubrica extends JPanel{

    private JTable tabella;
    private ModelloTabellaRubrica modelloTabella;

    public TabellaRubrica(){

        this.modelloTabella = new ModelloTabellaRubrica();
        this.tabella = new JTable(modelloTabella);

        setLayout(new BorderLayout());
        add(new JScrollPane(tabella), BorderLayout.CENTER);

    }
    
    public void setData(List <Persona> rubrica){

    }
}
