package gui.interfaces;

import commonclasses.DataTable;

/**
 * interface Grid defines the typical graphical table interactions
 * implementing classes must provide.
 * {@inheritDoc}
 */
 public interface Grid extends JGuiConvertible,Renderable {
    /**
     * isSortable Method returns a boolean value indicating whether or not the grid data
     * should be made sortable in the GUI.
     * @return Returns True if sortable, false otherwise.
     */
   boolean isSortable();

    /**
     * hasData returns a boolean value indicating wither or not there is any table data to return.
     * The presence or absence of other table descriptors such os headers and title do not influence it.
     * @return Returns true if there is table data, false otherwise.
     */
   boolean hasData();

    /**
     * getRowCount returns the number of data rows in the grid.
     * @return Returns he number of data rows in the grid, or zero if empty.
     */
   int getRowCount();

    /**
     * getColumnCount returns the number of columns in the grid.
     * @return Returns the number of columns in the grid whether or not they contain data.
     */
   int getColumnCount();

    /**
     * getRowData returns the data it contains.
     * @return returns the data it contains in a two-dimensional array, or null if empty
     */
   Object [][] getRowData();

    /**
     * getColumnNames returns the column names/headers of a grid.
     * @return returns the grid column names, or null if none defined.
     */
   String [] getColumnNames();

    /**
     * Sets the grid as sortable or not sortable.
     * @param canSort A boolean that sets the grid as sortable if true or false otherwise.
     */
    void setSortable(boolean canSort);

    /**
     * Sets the column names and row data of the Grid
     * @param table A DataTable containing the grid's data.
     */
    void setGridData(DataTable table);


    /**
     * Sets the row data of the grid
     * @param data A two dimensional array of objects containing row data.
     */
    void setRowData(Object[][] data);
    /**
     * Sets the column data of the grid
     * @param columnNames An array of String containing the column names.
     */
    void setColumnNames(String[] columnNames);
}
