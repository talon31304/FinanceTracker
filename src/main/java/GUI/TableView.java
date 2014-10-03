package GUI;
import CommonClasses.DataTable;
import GUI.abstractClasses.InsideBox;
import GUI.interfaces.Grid;


/**
 * Created by Rick on 9/27/2014.
 */
public class TableView extends InsideBox implements Grid {
    private Object RowData[][];
    private String ColumnNames[];
    private boolean Sortable;
    private boolean isEmpty;

    public TableBox()
    {
       isEmpty=true;
    }
    public TableBox(DataTable data, boolean sortable)
    {
       RowData=data.getRowData();
       ColumnNames=data.getColumnNames();
       isEmpty=!data.hasData();
       Sortable=sortable;
    }
    public TableBox(String title, Object rowData[][], String columnNames[], boolean sortable)
    {
        RowData=rowData;
        ColumnNames=columnNames;
        Sortable=sortable;
        isEmpty=false;
    }
    public boolean isSortable()
    {
        return Sortable;
    }
    public  int getRowCount()
    {
        return RowData.length;
    }
    public  int getColumnCount()
    {
        return RowData.length;
    }
    public  boolean hasData()
    {
        return !isEmpty;
    }
    public Object [][] getRowData()
    {
        return RowData;
    }
    public String [] getColumnNames()
    {
        return ColumnNames;
    }



}
