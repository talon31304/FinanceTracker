package gui.abstractClasses;
import commonclasses.DataTable;
import gui.interfaces.Grid;


/**
* Base abstract class that contains much, but not all functionality needed for GUI grid objects.
*/

public abstract class BaseGridView extends BaseGuiObject implements Grid {

    private Object rowData[][];
    private String columnNames[];
    private boolean sortable;


    /**
     * {@inheritDoc}
     * @return
     */
    public boolean isSortable()
    {
        return sortable;
    }

    /**
     * {@inheritDoc}
     * @return
     */
    public  int getRowCount()
    {
        return rowData.length;
    }

    /**
     * {@inheritDoc}
     * @return
     */
    public  int getColumnCount()
    {
        return rowData.length;
    }

    /**
     * {@inheritDoc}
     * @return
     */
    public  boolean hasData()
    {
        return getRowCount()>0;
    }

    /**
     * {@inheritDoc}
     * @return
     */
    public Object [][] getRowData()
    {
        return rowData;
    }

    /**
     * {@inheritDoc}
     * @return
     */
    public String [] getColumnNames()
    {
        return columnNames;
    }

    /**
     * {@inheritDoc}
     * @param canSort A boolean that sets the grid as sortable if true or false otherwise.
     */
    public void setSortable(boolean canSort){
        sortable =canSort;
    }

    /**
     * Sets the column names and row data of the Grid
     * @param table A DataTable containing the grid's data.
     */
    public void setGridData(DataTable table){
        rowData=table.getRowData();
    }


    /**
     * Sets the row data of the grid
     * @param data A two dimensional array of objects containing row data.
     */
    public void setRowData(Object[][] data){
        rowData=data;
    }
    /**
     * Sets the column data of the grid
     * @param columnNames An array of String containing the column names.
     */
    public void setColumnNames(String[] columnHeaders){columnNames=columnHeaders;}

}
