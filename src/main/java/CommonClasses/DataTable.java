package CommonClasses;

/**
 * Created by Rick on 9/26/2014.
 */
public interface DataTable {
    DataCell[][] getRowData();
    String[] getColumnNames();
    DataRow next();

    void first(); //Move to first non-header record
    DataRow getHeaderRow();
    void setHeaderRow(DataRow row);
    boolean hasHeader();
    boolean hasData();
    int getRowCount();
    void clear();
    int getIndexOf(DataRow row);
    void deleteRowAt(int index);
    void insertRowAt(DataRow row);
}
