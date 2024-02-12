package src.view;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import src.controller.Controller;
import src.model.Persona;

public class TabellaRubrica extends JPanel{

    private JTable tabella;
    private ModelloTabellaRubrica modelloTabella;

    public TabellaRubrica(Controller controller){

        this.modelloTabella = new ModelloTabellaRubrica();
        this.tabella = new JTable(modelloTabella);

        //nascondo la colonna degli id
        tabella.getColumnModel().getColumn(0).setMinWidth(0);
        tabella.getColumnModel().getColumn(0).setMaxWidth(0);
        tabella.getColumnModel().getColumn(0).setWidth(0);

        //verifico il click del mouse, identifico la riga cliccata, recupero dal database i dati della persona tramite id e li salvo nella variabile "selezionata"
        tabella.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e){
                if (e.getButton() == MouseEvent.BUTTON1) {
                    int rowIndex = tabella.rowAtPoint(e.getPoint());
                    int id = (int) tabella.getValueAt(rowIndex, 0);
                    controller.selezionaPersonaById(id);
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
