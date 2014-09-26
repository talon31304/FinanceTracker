package GUI;

import CommonClasses.DataTable;

/**
 * Created by Rick on 9/26/2014.
 */
public interface  GridView extends DataView{
    void removeRowAt();
    void insertRowAt();
    void setData(DataTable data);
    DataTable getData();
    void sortOn(int ColumnNumber);
    void setSortable(boolean allowSort);
    boolean getSortable();
    int getMaxRowsPerPage();
    void SetMaxRowsPerPage();
    void saveAsFile();
}
