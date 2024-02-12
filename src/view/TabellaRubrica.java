package src.view;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import src.model.Persona;

public class TabellaRubrica extends JPanel{

    private JTable tabella;
    private ModelloTabellaRubrica modelloTabella;
    private Persona selezionata;            //persona selezionata in caso di click su la tabella per eliminare o modificare

    public TabellaRubrica(){

        this.modelloTabella = new ModelloTabellaRubrica();
        this.tabella = new JTable(modelloTabella);
        selezionata = null;

        tabella.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e){
                if (e.getButton() == MouseEvent.BUTTON1) {
                    int rowIndex = tabella.rowAtPoint(e.getPoint());
                    
                }
            }
        });

        setLayout(new BorderLayout());
        add(new JScrollPane(tabella), BorderLayout.CENTER);

    }
    
    public void setData(List <Persona> rubrica){
        modelloTabella.setData(rubrica);
    }

    public void aggiorna(){
        modelloTabella.fireTableDataChanged();
    }
}
