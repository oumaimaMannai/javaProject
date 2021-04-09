package ingapplication;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author omaima
 */
public class MyModelPersonnel extends AbstractTableModel{
    private String[] columns;
    private Object[][] rows;
    
    public MyModelPersonnel() {
    }

    public MyModelPersonnel(String[] columns, Object[][] rows) {
        this.columns = columns;
        this.rows = rows;
    }
    

    @Override
    public int getRowCount() {
         return this.rows.length;
    }

    @Override
    public int getColumnCount() {
        return this.columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return this.rows[rowIndex][columnIndex];
    }
    
    public String getColumnName(int col)
    {
        return this.columns[col];
    }
    
}
