package src.view;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import src.model.Persona;

public class ModelloTabellaRubrica extends AbstractTableModel{

    List <Persona> rubrica;

    public ModelloTabellaRubrica (){

    }

    @Override
    public int getRowCount() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRowCount'");
    }

    @Override
    public int getColumnCount() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getColumnCount'");
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getValueAt'");
    }
    
    public void setData(List <Persona> rubrica){
        this.rubrica = rubrica;
    }
}
