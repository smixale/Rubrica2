package src.view;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import src.model.Persona;

public class ModelloTabellaRubrica extends AbstractTableModel{

    private List <Persona> rubrica;
    private String[] nomiColonne = {"Nome", "Cognome", "Indirizzo", "Telefono", "Eta'"};

    //restituisce il numero di righe dalla tabella
    @Override
    public int getRowCount() {
        return this.rubrica.size();
    }

    //restituisce in numero di colonne della tabella
    @Override
    public int getColumnCount() {
        return 5;
    }

    //recuper un informazione specifica presente in una riga e colonna della tabella
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Persona persona = rubrica.get(rowIndex);

        switch (columnIndex) {

            case 0:
                return persona.getNome();

            case 1:
                return persona.getCognome();

            case 2:
                return persona.getIndirizzo();

            case 3:
                return persona.getTelefono();

            case 4:
                return persona.getEta();
        
            default:
                return null;
        }
    }
    
    public void setData(List <Persona> rubrica){
        this.rubrica = rubrica;
    }

    public ModelloTabellaRubrica (){

    }

    @Override
    public String getColumnName(int column) {
        return nomiColonne[column];
    }
}
